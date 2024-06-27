package com.example.userresourceblocker.converter;

import com.example.userresourceblocker.domain.Resource;
import com.example.userresourceblocker.entity.ResourceEntity;
import org.springframework.stereotype.Component;

@Component
public class ResourcesMapper {

    public Resources mapEntityToDomain(ResourcesEntity entity) {
        return Resources.builder()
                .id(entity.getId())
                .equipmentName(entity.getEquipmentName())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .category(entity.getCategory())
                .build();
    }

    public ResourcesEntity mapDomainToEntity(Resources resources) {
        return ResourcesEntity.builder()
                .id(resources.getId())
                .equipmentName(resources.getEquipmentName())
                .quantity(resources.getQuantity())
                .price(resources.getPrice())
                .category(resources.getCategory())
                .build();
    }
}
