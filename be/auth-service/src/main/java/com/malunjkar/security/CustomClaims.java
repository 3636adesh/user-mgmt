package com.malunjkar.security;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CustomClaims {


    public Map<String, Object> of(String user){
       Map<String, Object> claims = new HashMap<>();
       claims.put("id", user);
       return claims;

    }


}
