package com.example.loginbackend.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdhaarOtpAuthDTO {
    private String aadhaarNo;
     private String phoneNumber;
     private String email;
     private String mode;
     private String otp;
     private String id;
}
