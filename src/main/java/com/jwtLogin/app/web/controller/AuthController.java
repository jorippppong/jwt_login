package com.jwtLogin.app.web.controller;

import com.jwtLogin.app.domain.Member;
import com.jwtLogin.app.service.AuthService;
import com.jwtLogin.app.web.dto.AuthRequest;
import com.jwtLogin.app.web.dto.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse.SignUpDTO> signup(
            @Valid @RequestPart("data") AuthRequest.signUpDTO data,
            @RequestPart("profileImage") MultipartFile profileImage
    ) throws IOException {
        Member member = authService.signup(data, profileImage);
        return ResponseEntity.ok(
                AuthResponse.SignUpDTO.builder()
                        .memberId(member.getId())
                        .nickname(member.getNickname())
                        .profileImageUrl(member.getProfileImageUrl())
                        .build());
    }

}
