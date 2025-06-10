package com.example.loginbackend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loginbackend.model.KycDocument;

public interface KycDocumentRepository extends JpaRepository<KycDocument, UUID> {
    
}
