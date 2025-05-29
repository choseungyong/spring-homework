package com.domain.app.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private final String token;
    private final String email;

    @Builder
    public MemberResponseDto(String token, String email){
        this.token = token;
        this.email = email;
    }
}
