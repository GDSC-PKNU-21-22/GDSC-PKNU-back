package com.gdsc.pknu.backend.controller.user;

import lombok.Getter;

@Getter
public class RegisterResult {
    private MemberDto memberDto;
    private String token;
    public RegisterResult(MemberDto memberDto, String token) {
        this.memberDto = memberDto;
        this.token = token;
    }
}
