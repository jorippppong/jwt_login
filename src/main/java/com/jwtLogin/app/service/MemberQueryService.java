package com.jwtLogin.app.service;

import com.jwtLogin.app.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberRepository memberRepository;

    public boolean existByEmail(String email){
        return memberRepository.existsByEmail(email);
    }

    public boolean existByNickname(String nickname){
        return memberRepository.existsByNickname(nickname);
    }
}
