package com.example.loginbackend.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdhaarDTO {
    private Boolean countrytype;
    private String phoneNumber;
    private String email;
    private String adhaarNo;
    private String mode;

}
