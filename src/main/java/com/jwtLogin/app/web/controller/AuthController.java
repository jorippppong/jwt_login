package com.jwtLogin.app.web.controller;

import com.jwtLogin.app.service.AuthService;
import com.jwtLogin.app.web.dto.AuthRequest;
import com.jwtLogin.app.web.dto.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse.SignUpDTO> signup(
            @Valid @RequestPart("data") AuthRequest.signUpDTO data,
            @RequestPart("profileImage") MultipartFile profileImage
    ){
        return ResponseEntity.ok(
                AuthResponse.SignUpDTO.builder()
                        .memberId(authService.signup(data, profileImage))
                        .build());
    }

}
