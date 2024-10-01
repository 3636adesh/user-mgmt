package com.malunjkar.vo.request;


public record UserCreationRequest(
         String username,
         String password,
         String firstName,
         String lastName,
         String email
){
}
