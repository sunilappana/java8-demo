package com.example.userresourceblocker.repository;

import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Inventory;

import java.util.List;

public interface ResourcesRepository {

    List<Resources> getAllEquipments();

    Resources getEquipment(Integer id);
    
    List<EquipmentRequest> getEquipmentRequest();

}
