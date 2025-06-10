package com.example.loginbackend.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table (name = "ksmart_user" )
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id", nullable = false, updatable = false)
    private UUID userId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "tenant_id")
    private Integer tenantId;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_kyc_verified")
    private Boolean isKycVerified;

    @Column(name = "aadhaar_id")
    private UUID aadhaarId;

    @Column(name = "aadhaar_no", length = 255)
    private String aadhaarNo;

    @Column(name = "is_first_login")
    private Boolean isFirstLogin;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "whatsapp_number", length = 255)
    private String whatsappNumber;

    @Column(name = "user_type", length = 255, nullable = false)
    private String userType;

    @Column(name = "reg_no")
    private Long regNo;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "is_document_verified")
    private Boolean isDocumentVerified = false;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "dob", length = 64)
    private String dob;

    @Column(name = "gender", length = 64)
    private String gender;

    @Column(name = "countrytype")
   private Boolean countrytype;
}
