package com.example.userresourceblocker.service.impl;

import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Resources;
import com.example.userresourceblocker.repository.ResourcesRepository;
import com.example.userresourceblocker.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    ResourcesRepository resourcesRepository;

    @Override
    public List<Resources> getAllEquipments() {
        return resourcesRepository.getAllEquipments();
    }

    @Override
    public Resources getEquipment(Integer id) {
        return resourcesRepository.getEquipment(id);
    }

    @Override
    public List<EquipmentRequest> getEquipmentRequest() {
        return resourcesRepository.getEquipmentRequest();
    }

}
