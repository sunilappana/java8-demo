package com.example.userresourceblocker.converter;

import com.example.userresourceblocker.domain.EquipmentRequest;
import com.example.userresourceblocker.entity.EquipmentRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class EquipmentRequestMapper {

    public EquipmentRequest mapEntityToDomain(EquipmentRequestEntity entity) {
        return EquipmentRequest.builder()
                .id(entity.getId())
                .equipmentId(entity.getEquipmentId())
                .userId(entity.getUserId())
                .status(entity.getStatus())
                .build();
    }

    public EquipmentRequestEntity mapDomainToEntity(EquipmentRequest equipmentRequest) {
        return EquipmentRequestEntity.builder()
                .id(equipmentRequest.getId())
                .equipmentId(equipmentRequest.getEquipmentId())
                .userId(equipmentRequest.getUserId())
                .status(equipmentRequest.getStatus())
                .build();
    }
}
