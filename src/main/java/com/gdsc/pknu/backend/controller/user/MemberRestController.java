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
            @ModelAttribute RegisterRequest request,
            @RequestPart(required = false)MultipartFile imageFile
            ){

        Member member = memberService.register(Member.builder()
                .email(new Email(request.getEmail()))
                .password(request.getPassword())
                .studentNumber(request.getStudentNumber())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .majorId(request.getMajorId())
                .role(Role.USER)
                .imagePath(request.getImagePath())
                .githubUrl(request.getGithubUrl())
                .build());

        String token = member.generateApiToken(jwt, new String[]{"ROLE_USER"});
        return ApiRes.SUCCESS(new RegisterResult(new MemberDto(member), token));
    }

}
