package com.domain.app.member.service;

import com.domain.app.global.jwt.JwtTokenProvider;
import com.domain.app.member.domain.Member;
import com.domain.app.member.domain.Role;
import com.domain.app.member.dto.MemberRequestDto;
import com.domain.app.member.dto.MemberResponseDto;
import com.domain.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public MemberResponseDto register(MemberRequestDto requestDto) {
        if(memberRepository.findByEmail(requestDto.getEmail()).isPresent()){
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());

        Role role = requestDto.getEmail().startsWith("admin") ? Role.ADMIN : Role.USER;

        Member member = Member.builder()
                .email(requestDto.getEmail())
                .password(encodedPassword)
                .role(role)
                .build();

        memberRepository.save(member);

        String token = jwtTokenProvider.createToken(member.getEmail(), member.getRole().name());

        return MemberResponseDto.builder()
                .token(token)
                .email(member.getEmail())
                .build();
    }

    public MemberResponseDto login(MemberRequestDto requestDto) {
        Member member = memberRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일 입니다."));

        if(!passwordEncoder.matches(requestDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtTokenProvider.createToken(member.getEmail(), member.getRole().name());

        return MemberResponseDto.builder()
                .token(token)
                .email(member.getEmail())
                .build();
    }

    public MemberResponseDto getMyInfo(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return new MemberResponseDto(member.getEmail(), null);
    }
}
