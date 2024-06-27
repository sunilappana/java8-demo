package com.example.userresourceblocker.jpa;

import com.example.userresourceblocker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAUserDetailsRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByUserEmail(String userEmail);
}
