package com.example.userresourceblocker.service;

import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Resources;

import java.util.List;

public interface ResourcesService {

    List<Resources> getAllEquipments();

    Resources getEquipment(Integer id);

    List<EquipmentRequest> getEquipmentRequest();

}
