package com.domain.app.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ProfileController {

    @GetMapping("/api/profile")
    public ResponseEntity<String> myProfile(HttpServletRequest request) {
        String email = (String) request.getAttribute("userEmail");
        return ResponseEntity.ok("안녕하세요, "+email+"님");
    }
}
