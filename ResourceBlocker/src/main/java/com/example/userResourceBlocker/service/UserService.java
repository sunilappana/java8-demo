package com.example.userresourceblocker.service;

import com.example.userresourceblocker.domain.Resources;
import com.example.userresourceblocker.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserDetails(String userEmail);

    User getUserDetailById(Integer id);

    Integer registerUser(User user, boolean isEdit, boolean isPasswordChange);

    void sendRequest(String userEmail, Integer id);

    List<Resources> getEquipmentsBySearch(String keyword);
}
