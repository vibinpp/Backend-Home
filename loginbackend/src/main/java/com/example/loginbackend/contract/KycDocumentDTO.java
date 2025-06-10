package com.example.loginbackend.contract;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class KycDocumentDTO {
    private String documentType;
    private UUID userId;          // user ID or session identifier
    private String mode;
    private String documentNo;
    private MultipartFile file;

}
