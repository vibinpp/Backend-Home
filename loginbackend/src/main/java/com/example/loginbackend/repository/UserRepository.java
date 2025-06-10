package com.example.loginbackend.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginbackend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
     //Optional <Users> findByUsernameAndPassword(String username, String password);
     Optional <User> findByPhoneNumberAndIsActive(String phoneNumber, Boolean isActive);
      Optional <User> findByEmailAndIsActive(String email, Boolean isActive);
      Optional <User> findByAadhaarNo(String aadhaarNo);
     // User findByPhoneNumberAndIsActive(String PhoneNumber, Boolean isActive);
}
