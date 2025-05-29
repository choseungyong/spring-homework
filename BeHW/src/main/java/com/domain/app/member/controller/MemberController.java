package com.domain.app.member.controller;

import com.domain.app.member.dto.MemberRequestDto;
import com.domain.app.member.dto.MemberResponseDto;
import com.domain.app.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> register(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto responseDto = memberService.register(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto> login(@RequestBody MemberRequestDto requestDto) {
        MemberResponseDto responseDto = memberService.login(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyInfo(HttpServletRequest request) {
        String email = (String) request.getAttribute("userEmail");
        MemberResponseDto responseDto = memberService.getMyInfo(email);
        return ResponseEntity.ok(responseDto);
    }
}
