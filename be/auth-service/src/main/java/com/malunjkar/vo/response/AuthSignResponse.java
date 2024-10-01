package com.malunjkar.vo.response;

import com.malunjkar.vo.traveller.UserSignResponse;

public record AuthSignResponse(
        String message,
        String accessToken,
        UserSignResponse userInfo
) {
}
