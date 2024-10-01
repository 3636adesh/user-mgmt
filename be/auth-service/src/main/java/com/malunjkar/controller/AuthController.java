package com.malunjkar.controller;


import com.malunjkar.vo.request.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {



    @PostMapping("/log-in")
    public ResponseEntity<?> logIn(@Valid @RequestBody LoginRequest loginRequest) {
        String message="success";
        return ResponseEntity.ok(message);
    }
}
