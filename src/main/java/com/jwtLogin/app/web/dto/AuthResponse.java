package com.jwtLogin.app.web.dto;

import lombok.Builder;
import lombok.Getter;

public class AuthResponse {

    @Getter
    @Builder
    public static class SignUpDTO{
        private Long memberId;
        private String nickname;
        private String profileImageUrl;
    }
}
