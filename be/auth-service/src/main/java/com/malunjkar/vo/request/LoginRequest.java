package com.malunjkar.vo.request;

import jakarta.validation.constraints.Email;

public record LoginRequest(
        @Email
        String email,
        String username, String password) {
}
