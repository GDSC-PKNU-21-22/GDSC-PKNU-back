package com.gdsc.pknu.backend.controller.user;

import com.gdsc.pknu.backend.controller.ApiRes;
import com.gdsc.pknu.backend.domain.authentication.Jwt;
import com.gdsc.pknu.backend.domain.member.Email;
import com.gdsc.pknu.backend.domain.member.Member;
import com.gdsc.pknu.backend.domain.member.Role;
import com.gdsc.pknu.backend.service.MemberService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/member")
public class MemberRestController {

    private final MemberService memberService;
    private final Jwt jwt;

    public MemberRestController(MemberService memberService, Jwt jwt) {
        this.memberService = memberService;
        this.jwt = jwt;
    }

    @PostMapping()
    public ApiRes<RegisterResult> register(
            @ModelAttribute RegisterRequest registerRequest,
            @RequestPart(required = false)MultipartFile imageFile
            ){

        Member member = memberService.register(Member.from(
                new Email(registerRequest.getEmail()), registerRequest.getPassword(), registerRequest.getStudentNumber(),
                registerRequest.getName(), registerRequest.getMajor(), Role.USER
                ));

        String token = member.generateApiToken(jwt, new String[]{"ROLE_USER"});
        return ApiRes.SUCCESS(new RegisterResult(new MemberDto(member), token));
    }

}
