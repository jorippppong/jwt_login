package com.jwtLogin.app.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AuthRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class signUpDTO{
        // TODO : 중복 validation 추가
        @NotBlank(message = "email을 작성해주세요.")
        private String email;

        @NotBlank(message = "password를 작성해주세요.")
        private String password;

        @NotBlank(message = "nickname을 입력해주세요.")
        private String nickname;
    }
}
