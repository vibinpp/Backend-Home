package com.example.loginbackend.Utility;

//import java.security.SecureRandom;
import java.util.Random;

// public class OtpUtil {
//     private static final String DIGITS = "0123456789";
//     private static final int OTP_LENGTH = 6;

//     public static String generateOtp() {
//         SecureRandom random = new SecureRandom();
//         StringBuilder otp = new StringBuilder();
//         for (int i = 0; i < OTP_LENGTH; i++) {
//             otp.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
//         }
//         return otp.toString();
//     }
// }
public class OtpUtil {
    public static String generateOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }
}
