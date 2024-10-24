package com.malunjkar;

import com.malunjkar.encryption.RSAService;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;

public class RSAKeyTest {


    @Test
    void testPrivateRSAKey() {
        try {
            PrivateKey privateKey = RSAService.getPrivateKey();
            System.out.println(privateKey);
        }catch (Exception e) {}
    }
}
