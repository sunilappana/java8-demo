package com.example.userresourceblocker.repository.impl;

import com.example.userresourceblocker.converter.EquipmentRequestMapper;
import com.example.userresourceblocker.converter.ResourcesMapper;
import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.domain.Resources;
import com.example.userresourceblocker.entity.EquipmentRequestEntity;
import com.example.userresourceblocker.entity.ResourcesEntity;
import com.example.userresourceblocker.jpa.JPAEquipmentRequestRepository;
import com.example.userresourceblocker.jpa.JPAResourcesRepository;
import com.example.userresourceblocker.repository.ResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ResourcesRepositoryImpl implements ResourcesRepository {

    @Autowired
    JPAResourcesRepository jpaResourcesRepository;

    @Autowired
    JPAEquipmentRequestRepository jpaEquipmentRequestRepository;

    @Autowired
    ResourcesMapper resourcesMapper;

    @Autowired
    EquipmentRequestMapper equipmentRequestMapper;

    @Override
    public List<Resources> getAllEquipments() {
        List<ResourcesEntity> resourcesEntities = jpaResourcesRepository.findAll();
        return resourcesEntities.stream().map(resourcesEntity -> resourcesMapper.mapEntityToDomain(resourcesEntity)).collect(Collectors.toList());
    }

    @Override
    public Resources getEquipment(Integer id) {
        return resourcesMapper.mapEntityToDomain(jpaResourcesRepository.getOne(id));
    }

    @Override
    public List<EquipmentRequest> getEquipmentRequest() {
        List<EquipmentRequestEntity> equipmentRequestEntities = jpaEquipmentRequestRepository.findByStatus(0);
        return equipmentRequestEntities.stream().map(equipmentRequestEntity -> equipmentRequestMapper.mapEntityToDomain(equipmentRequestEntity)).collect(Collectors.toList());
    }
}
