package com.domain.app.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGen {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("1234"));  // 또는 원하는 비밀번호
    }
}