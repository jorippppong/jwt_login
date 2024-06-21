package com.jwtLogin.app.web.dto;

import com.jwtLogin.global.annotation.ExistEmail;
import com.jwtLogin.global.annotation.ExistNickname;
import jakarta.validation.constraints.Email;
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
        @NotBlank(message = "email을 작성해주세요.") @Email @ExistEmail
        private String email;

        @NotBlank(message = "password를 작성해주세요.")
        private String password;

        @NotBlank(message = "nickname을 입력해주세요.") @ExistNickname
        private String nickname;
    }
}
