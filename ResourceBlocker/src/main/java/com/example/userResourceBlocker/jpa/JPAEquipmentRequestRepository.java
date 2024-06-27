package com.example.userresourceblocker.jpa;

import com.example.userresourceblocker.entity.EquipmentRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAEquipmentRequestRepository extends JpaRepository<EquipmentRequestEntity, Integer> {

    List<EquipmentRequestEntity> findByStatus(Integer status);
}
