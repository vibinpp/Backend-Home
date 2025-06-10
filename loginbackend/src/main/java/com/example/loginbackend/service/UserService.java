package com.example.loginbackend.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.loginbackend.Utility.OtpUtil;
import com.example.loginbackend.contract.AdhaarDTO;
import com.example.loginbackend.contract.AdhaarOtpAuthDTO;
import com.example.loginbackend.contract.UserAuthDTO;
import com.example.loginbackend.contract.UserDTO;
import com.example.loginbackend.contract.VerifyOtpDTO;
import com.example.loginbackend.model.User;
import com.example.loginbackend.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private OtpService otpService;

    public String saveUser(UserDTO request){
         User users = modelMapper.map(request, User.class);
           userRepository.save(users); 
           return "Successfully saved";
      }

    public String checkUser(UserDTO request) {
          if (request.getPhoneNumber() != null ){     
            Optional <User> check = userRepository.findByPhoneNumberAndIsActive(request.getPhoneNumber(), true);
           //return check.isPresent()? ("Already exist") : ("No User Exist");
            if (check.isPresent()){
                  return "User Already exist";
            }
            else{
              // String key = "OTP:PHONE:" + request.getPhoneNumber();
              //   String otp = otpService.generateAndStoreOtp(key);
              //   // In real application, send OTP via SMS here
              //   return "OTP sent: ";//+ otp; // Return masked in production
               //   String otp = OtpUtil.generateOtp();
            // TODO: Store OTP in DB or in-memory map and send via email
           // return "otp";
            //generate otpppp
             return "235617";
            }
          }
         else if (request.getEmail() != null ){
                   Optional <User> check = userRepository.findByEmailAndIsActive(request.getEmail(), true);
           //return check.isPresent()? ("Already exist") : ("No User Exist");
                   if (check.isPresent()){
                  return "Already exist";
                   }
                  else{
                        String otp = OtpUtil.generateOtp();
            // TODO: Store OTP in DB or in-memory map and send via SMS
          //  return "otp";
            //generate otpppp
                     return "235617";
                   }
               }
               else{
                   return "Invalid request: phone number or email must be provided";
                  }
      }

    public String verifyOtp(VerifyOtpDTO request) {
      
      if("235617".equals(request.getOtp())){
            User usr = new User();
            if ("India".equals(request.getMode())){
          //  usr.getPhoneNumber()===request.getPhoneNumber();
          usr.setPhoneNumber(request.getId());
          usr.setCountrytype(true);
          usr.setIsActive(true);
          usr.setUserType("Citizen");
          usr.setIsFirstLogin(true);
          usr.setCreatedAt(LocalDateTime.now());
             userRepository.save(usr);

            return "success";
            }
            else{
           usr.setEmail(request.getId());
          usr.setCountrytype(false);
          usr.setIsActive(true);
          usr.setUserType("Citizen");
          usr.setIsFirstLogin(true);
          usr.setCreatedAt(LocalDateTime.now());
             userRepository.save(usr);

            return "success";

            }
      }
      else {
      return "failed";
      }
    }

    public String authUser(UserAuthDTO request){
         String userId = request.getUserId();
        Optional<User> checkUser;

    if (userId.matches("^[6-9]\\d{9}$")) {
           checkUser = userRepository.findByPhoneNumberAndIsActive(userId, true);
    } else if (userId.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
        checkUser = userRepository.findByEmailAndIsActive(userId, true);
    } else {
        return "Invalid user ID format";
    }

    return checkUser.isPresent() ? "Success" : "Failed";

  }  

    public String verifyLoginOtp(VerifyOtpDTO request) {
      System.out.println("OTP: " + request.getOtp()); //checking
    System.out.println("UserId: " + request.getUserId()); //checking
        if("235617".equals(request.getOtp())){
          System.out.println("Received Otp: " + request.getOtp());  //checking
        String userId = request.getUserId();
        Optional<User> checkUser;

         if (userId.matches("^[6-9]\\d{9}$")) {
           checkUser = userRepository.findByPhoneNumberAndIsActive(userId, true);
    } else if (userId.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
        checkUser = userRepository.findByEmailAndIsActive(userId, true);
    } else {
        return "Invalid user ID format";
    }

     if (checkUser.isPresent()) {
       User user = checkUser.get();
       Boolean isKycVerified = user.getIsKycVerified();
            if (Boolean.TRUE.equals(isKycVerified)){
                 return "Success";
               }
            else{
                   return "NoKyc";
                 }
      
       // return "";
        }
        else {
        return "Invalid user ID format";
        }
      }
     else {
        return "Failed";
        }   
    // return "Success";
  }

    public String adhaarKyc(AdhaarDTO request) {
      Optional<User> checkUser = userRepository.findByAadhaarNo(request.getAdhaarNo());
      if (!checkUser.isPresent()){
                  return "Success"; // otp generate and sent 
                   }
          else{
            return "Failed";
          }
     // return !checkUser.isPresent() ? "Success" : "Failed";

     // return "hi";
    }

   public String adhaarOtpVerify(AdhaarOtpAuthDTO request) {
        if("235617".equals(request.getOtp())){
       //   User usr = new User();
         Optional <User> usr = userRepository.findByPhoneNumberAndIsActive(request.getPhoneNumber(), true);      //   usr = userRepository.findByPhoneNumberAndIsActive(request.getPhoneNumber(), true);
        //   usr.setAdhaarNo(request.getAadhaarNo());
        
        if (usr.isPresent()){
           User user = usr.get(); 
           System.out.println("Received Aadhaar No: " + request.getAadhaarNo());
              user.setAadhaarNo(request.getAadhaarNo());
            //usr.setAadhaaruest.getAadhaarNo());
              user.setIsKycVerified(true);
               userRepository.save(user);
        return "Success";
        }
        else {
          return "Something went wrong";
        }
      }
        else {
        return "Failed";
        }
    }

    
}