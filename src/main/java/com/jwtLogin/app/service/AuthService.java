package com.jwtLogin.app.service;

import com.jwtLogin.app.domain.Authority;
import com.jwtLogin.app.domain.LoginType;
import com.jwtLogin.app.domain.Member;
import com.jwtLogin.app.repository.MemberRepository;
import com.jwtLogin.app.web.dto.AuthRequest;
import com.jwtLogin.global.file.AwsFileService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final AwsFileService awsFileService;
    //private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member signup(AuthRequest.signUpDTO data, MultipartFile profileImage) throws IOException {
        //String password = passwordEncoder.encode(data.getPassword());
        String profileImageUrl = awsFileService.saveFile(profileImage);

        Member newMember = Member.builder()
                .email(data.getEmail())
                .password(data.getPassword())
                .nickname(data.getNickname())
                .profileImageUrl(profileImageUrl)
                .loginType(LoginType.SELF)
                .authority(Authority.ROLE_USER)
                .build();

        return memberRepository.save(newMember);
    }
}
