package com.gdsc.pknu.backend.controller;

import com.gdsc.pknu.backend.data.Member;
import com.gdsc.pknu.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


@Controller
public class SignInController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignInController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("sign-in")
    public String createForm() {
        return "singInForm";
    }

    // 회원가입 데이터 등록
    @PostMapping("sign-in")
    public String createMember(HttpServletRequest request) {
        Member newMember = new Member();
        Enumeration memberInfo = request.getParameterNames();
        newMember.setEmail(request.getParameter("email"));
        newMember.setStudentNumber(request.getParameter("studentNumber"));
        newMember.setName(request.getParameter("name"));
        newMember.setPhoneNumber(request.getParameter("phoneNumber"));
        newMember.setMajor(request.getParameter("major"));
        newMember.setGithub(request.getParameter("githubUrl"));
        System.out.println(newMember.getEmail());
        // 비밀번호 암호화하여 저장
        newMember.setPassword(passwordEncoder.encode(request.getParameter("password")));
        System.out.println(passwordEncoder.encode(request.getParameter("password")));
        memberService.join(newMember);

        return "redirect:/";
    }

//    @PostMapping("sign-in")
//    public String createMember(@RequestBody Map<String, Object> requestData){
//        JSONObject newMember = new JSONObject(requestData);
//        Member member = new Member();
//        JSONObject sendMember = newMember.getJSONObject("member");
//        member.setName(sendMember.getString("name"));
//        member.setMajor(sendMember.getString("major"));
//
//        return "redirect:/";
//    }
}
