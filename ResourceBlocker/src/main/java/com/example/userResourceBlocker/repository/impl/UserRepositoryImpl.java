package com.example.userresourceblocker.repository.impl;

import com.example.userresourceblocker.converter.EquipmentRequestMapper;
import com.example.userresourceblocker.converter.ResourcesMapper;
import com.example.userresourceblocker.converter.UserDetailsMapper;
import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Resources;
import com.example.userresourceblocker.domain.User;
import com.example.userresourceblocker.entity.EquipmentRequestEntity;
import com.example.userresourceblocker.entity.ResourcesEntity;
import com.example.userresourceblocker.entity.UserEntity;
import com.example.userresourceblocker.jpa.JPAEquipmentRequestRepository;
import com.example.userresourceblocker.jpa.JPAResourcesRepository;
import com.example.userresourceblocker.jpa.JPAUserDetailsRepository;
import com.example.userresourceblocker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    JPAUserDetailsRepository jpaUserDetailsRepository;

    @Autowired
    JPAEquipmentRequestRepository jpaEquipmentRequestRepository;

    @Autowired
    JPAResourcesRepository jpaResourcesRepository;

    @Autowired
    UserDetailsMapper userDetailsMapper;

    @Autowired
    ResourcesMapper resourcesMapper;

    @Autowired
    EquipmentRequestMapper equipmentRequestMapper;

    @Override
    public User getUserDetails(String userEmail) {
        UserEntity userEntity = jpaUserDetailsRepository.findByUserEmail(userEmail);
        return userDetailsMapper.mapEntityToDomain(userEntity);
    }

    @Override
    public Integer registerUser(User user) {
        UserEntity userEntity = userDetailsMapper.mapDomainToEntity(user);
        return jpaUserDetailsRepository.save(userEntity).getId();

    }
    
    @Override
    public User getUserDetailById(Integer id) {
        return userDetailsMapper.mapEntityToDomain(jpaUserDetailsRepository.getOne(id));
    }

    @Override
    public void deleteUserDetail(User user) {
        UserEntity userEntity = userDetailsMapper.mapDomainToEntity(user);
        jpaUserDetailsRepository.delete(userEntity);
    }

    @Override
    public void sendRequest(EquipmentRequest equipmentRequest) {
        EquipmentRequestEntity equipmentRequestEntity = equipmentRequestMapper.mapDomainToEntity(equipmentRequest);
        jpaEquipmentRequestRepository.save(equipmentRequestEntity);
    }

    @Override
    public List<Resources> getEquipmentsBySearch(String keyword) {
        List<ResourcesEntity> resourcesEntities = jpaResourcesRepository.getEquipmentsByKeyword(keyword);
        return resourcesEntities.stream().map(entity -> resourcesMapper.mapEntityToDomain(entity)).collect(Collectors.toList());
    }


}
