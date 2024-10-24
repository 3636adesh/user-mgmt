package com.malunjkar;

import com.malunjkar.security.JwtUtil;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Test {


    @Bean
    ApplicationRunner applicationRunner(JwtUtil jwtUtil) {
        return args -> {
            System.out.println(jwtUtil.generateToken("Adesh"));
        };
    }
}
