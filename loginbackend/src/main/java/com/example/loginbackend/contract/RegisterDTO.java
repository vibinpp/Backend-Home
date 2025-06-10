package com.example.loginbackend.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private Boolean countrytype;
    private String phoneNumber;
    private String email;
}
