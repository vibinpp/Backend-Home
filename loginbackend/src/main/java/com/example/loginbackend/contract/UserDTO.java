package com.example.loginbackend.contract;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
   @Id
    private UUID userid;
     private String phoneNumber;
    private Integer tenantId;
     private String name;
     private Boolean isActive;
     private Boolean isKycVerified;
    private UUID aadhaarId;
    private String aadhaarNo;
    private Boolean isFirstLogin;
    private String email;
    private String whatsappNumber;
    private String userType;
    private Long regNo;
    private LocalDateTime createdAt;
    private Boolean isDocumentVerified;
    private LocalDateTime updatedAt;
    private String dob;
    private String gender;
   private Boolean countrytype;
   private String mode;


}
