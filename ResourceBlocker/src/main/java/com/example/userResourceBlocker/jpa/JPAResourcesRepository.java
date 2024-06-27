package com.example.userresourceblocker.jpa;

import com.example.userresourceblocker.entity.ResourcesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JPAResourcesRepository extends JpaRepository<ResourcesEntity, Integer> {

    @Query(value = "SELECT * FROM resources ie WHERE ie.equipment_name LIKE %:keyword% or ie.category LIKE %:keyword%", nativeQuery = true)
    List<ResourcesEntity> getEquipmentsByKeyword(@Param("keyword") String keyword);
}
