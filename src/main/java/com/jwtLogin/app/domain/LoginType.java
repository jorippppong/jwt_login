package com.jwtLogin.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoginType {
    SELF(0, "Self"),
    GOOGLE(1, "Google"),
    KAKAO(2, "Kakao"),
    NAVER(3, "Naver");

    private final Integer value;
    private final String type;
}
