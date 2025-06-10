package com.example.loginbackend.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.loginbackend.contract.KycDocumentDTO;
import com.example.loginbackend.model.KycDocument;
import com.example.loginbackend.service.KycDocumentService;

import lombok.AllArgsConstructor;


 @RestController
//@RequestMapping("/api/kyc")
@AllArgsConstructor
//@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // Adjust as needed
public class KycDocumentController {

    private final KycDocumentService kycDocumentService;

    @PostMapping("/upload")
    public String uploadDocument(
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file,
            @RequestParam(value = "userId", required = false) UUID userId,
            @RequestParam(value = "mode", required = false) String mode,
            @RequestParam(value = "documentNo", required = false) String documentNo
    ) {
        try {
            KycDocumentDTO dto = KycDocumentDTO.builder()
                    .documentType(documentType)
                    .file(file)
                    .userId(userId)
                    .mode(mode)
                    .documentNo(documentNo)
                    .build();

            KycDocument savedDoc = kycDocumentService.uploadDocument(dto);
            return "Successfully Saved";
        } catch (Exception e) {
            e.printStackTrace();
            return "Upload failed";
        }
    }
}

    

