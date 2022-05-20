package com.gdsc.pknu.backend.controller;

import javax.servlet.http.HttpServletResponse;

import com.gdsc.pknu.backend.dto.MemberParam;
import com.gdsc.pknu.backend.service.MemberSignUpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    
    private final MemberSignUpService memberSignUpService;

    @Autowired
    public SignUpController(MemberSignUpService memberSignUpService) {

        this.memberSignUpService = memberSignUpService;

    }

    @PostMapping("/sign-up")
    public void memberSignUp(MemberParam memberParam, HttpServletResponse response) {

        memberSignUpService.memberSignUp(memberParam, response);

    }

}

