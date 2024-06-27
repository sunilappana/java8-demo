package com.example.userresourceblocker.repository;

import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Resources;
import com.example.userresourceblocker.domain.User;

import java.util.List;

public interface UserRepository {

    User getUserDetails(String userEmail);

    Integer registerUser(User user);

    User getUserDetailById(Integer id);

    void deleteUserDetail(User user);

    void sendRequest(EquipmentRequest equipmentRequest);

    List<Resources> getEquipmentsBySearch(String keyword);
}
