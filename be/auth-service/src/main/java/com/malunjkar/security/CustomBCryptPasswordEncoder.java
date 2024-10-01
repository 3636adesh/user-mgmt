package com.malunjkar.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class CustomBCryptPasswordEncoder {

    private final BCryptPasswordEncoder passwordEncoder;

    public CustomBCryptPasswordEncoder() throws NoSuchAlgorithmException {
        int strength = 12;
        String algorithm = "SHA256PRNG";
        SecureRandom secureRandom = SecureRandom.getInstance(algorithm);
        this.passwordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2Y, strength, secureRandom);
    }

    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
