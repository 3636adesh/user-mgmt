package com.malunjkar.vo.traveller;

import java.time.ZonedDateTime;

public record UserSignResponse (
        String username,
        String accessToken,
        ZonedDateTime expiresAt
){
}
