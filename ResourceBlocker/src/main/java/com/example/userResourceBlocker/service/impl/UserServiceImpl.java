package com.example.userresourceblocker.service.impl;

import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Resources;
import com.example.userv.domain.User;
import com.example.userresourceblocker.repository.UserRepository;
import com.example.userresourceblocker.service.ResourcesService;
import com.example.userresourceblocker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ResourcesService resourcesService;

    @Override
    public User getUserDetails(String userEmail) {
        return userRepository.getUserDetails(userEmail);
    }

    @Override
    public User getUserDetailById(Integer id) {
        return userRepository.getUserDetailById(id);
    }

    @Override
    public Integer registerUser(User user, boolean isEdit, boolean isChangePassword) {
        User existingUser = getUserDetails(user.getUserEmail());
        if (ObjectUtils.isEmpty(existingUser) || isChangePassword)
            return userRepository.registerUser(user);
        if (isEdit) {
            user.setUserPassword(existingUser.getUserPassword());
            return userRepository.registerUser(user);
        }
        return null;
    }

    @Override
    public void sendRequest(String userEmail, Integer id) {
        Resources resources = resourcesService.getEquipment(id);
        User user = getUserDetails(userEmail);
        EquipmentRequest equipmentRequest = EquipmentRequest.builder()
                .equipmentId(resources.getId())
                .userId(user.getId())
                .status(0).build();
        List<EquipmentRequest> equipmentRequests = resourcesService.getEquipmentRequest();
        List<EquipmentRequest> finalRquest = equipmentRequests.stream().filter(equipmentRequest1 -> equipmentRequest1.getEquipmentId().equals(id) && equipmentRequest1.getUserId().equals(user.getId())).collect(Collectors.toList());
        if (finalRquest.isEmpty())
            userRepository.sendRequest(equipmentRequest);
    }

    @Override
    public List<Resources> getEquipmentsBySearch(String keyword) {
        return userRepository.getEquipmentsBySearch(keyword);
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.getUserDetails(userEmail);
        if (user == null || user.getRole().equals("admin")) {
            throw new UsernameNotFoundException("User not found");
        }
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), authorities);

    }
}
