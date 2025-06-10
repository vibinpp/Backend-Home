package com.example.loginbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginbackend.contract.AdhaarDTO;
import com.example.loginbackend.contract.AdhaarOtpAuthDTO;
import com.example.loginbackend.contract.UserAuthDTO;
import com.example.loginbackend.contract.UserDTO;
import com.example.loginbackend.contract.VerifyOtpDTO;
import com.example.loginbackend.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/") 
public class UserController {
    private final UserService userService;

     @PostMapping("/register")
    public String saveUser(@RequestBody UserDTO request) {               
        return userService.saveUser(request);
    }
    @PostMapping("/checkid")
    public String checkUser(@RequestBody UserDTO request){
        return userService.checkUser(request);
    }

     @PostMapping("/VerifyotpReg")
     public String verifyOtp(@RequestBody VerifyOtpDTO request){
        return userService.verifyOtp(request);
     }

      @PostMapping("/AuthUser")
     public String authUser(@RequestBody UserAuthDTO request){
        return userService.authUser(request);
     }
    
     @PostMapping("/VerifyLoginOtp")
     public String verifyLoginOtp(@RequestBody VerifyOtpDTO request){
        return userService.verifyLoginOtp(request);
     }

     @PostMapping("/AdhaarKyc")
     public String adhaarKyc(@RequestBody AdhaarDTO request){
        return userService.adhaarKyc(request);
     }

     @PostMapping("/AdhaarOtpVerify")
     public String adhaarOtpVerify(@RequestBody AdhaarOtpAuthDTO request){
        return userService.adhaarOtpVerify(request);
     }
    
}
