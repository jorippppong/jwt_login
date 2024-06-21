package com.jwtLogin.app.service;

import com.jwtLogin.app.domain.Authority;
import com.jwtLogin.app.domain.LoginType;
import com.jwtLogin.app.domain.Member;
import com.jwtLogin.app.repository.MemberRepository;
import com.jwtLogin.app.web.dto.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long signup(AuthRequest.signUpDTO data, MultipartFile profileImage) {
        String password = passwordEncoder.encode(data.getPassword());
        String profileImageUrl = ""; // TODO : aws s3 저장 및 url 반환

        Member newMember = Member.builder()
                .email(data.getEmail())
                .password(password)
                .nickname(data.getNickname())
                .profileImageUrl(profileImageUrl)
                .loginType(LoginType.SELF)
                .authority(Authority.ROLE_USER)
                .build();

        return memberRepository.save(newMember).getId();
    }
}
