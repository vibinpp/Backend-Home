package com.example.loginbackend.service;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.loginbackend.Utility.OtpUtil;

@Service
//@AllArgsConstructor
public class OtpService {
      private static final long OTP_TTL_MINUTES = 5;
    private final RedisTemplate<String, String> redisTemplate;

    //@Autowired
    public OtpService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String generateAndStoreOtp(String key) {
        String otp = OtpUtil.generateOtp();
        redisTemplate.opsForValue().set(key, otp, Duration.ofMinutes(OTP_TTL_MINUTES));
        return otp;
    }

    public boolean validateOtp(String key, String otpInput) {
        String storedOtp = redisTemplate.opsForValue().get(key);
        if (storedOtp != null && storedOtp.equals(otpInput)) {
            redisTemplate.delete(key);
            return true;
        }
        return false;
    }
}
