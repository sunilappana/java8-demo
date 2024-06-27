package com.example.userresourceblocker.converter;

import com.example.userresourceblocker.domain.User;
import com.example.userresourceblocker.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserDetailsMapper {

    public User mapEntityToDomain(UserEntity entity) {
        if (ObjectUtils.isEmpty(entity))
            return null;
        return User.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .userEmail(entity.getUserEmail())
                .userPassword(entity.getUserPassword())
                .mobileNo(entity.getMobileNo())
                .address(entity.getAddress())
                .role(entity.getRole())
                .build();
    }

    public UserEntity mapDomainToEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userEmail(user.getUserEmail())
                .userPassword(user.getUserPassword())
                .mobileNo(user.getMobileNo())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }
}
