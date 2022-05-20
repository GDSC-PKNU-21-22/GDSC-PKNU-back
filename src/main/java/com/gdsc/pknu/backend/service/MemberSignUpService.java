package com.gdsc.pknu.backend.service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import com.gdsc.pknu.backend.dto.MemberParam;
import com.gdsc.pknu.backend.entity.Member;
import com.gdsc.pknu.backend.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class MemberSignUpService {

    private MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberSignUpService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {

        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;

    }
    
    public void memberSignUp(MemberParam memberParam, HttpServletResponse response) {

        // 중복검사
        if (memberRepository.findByEmail(memberParam.getEmail()) != null) {
            response.setStatus(409);
            return;
        }

        Member member = new Member();
        member.setEmail(memberParam.getEmail());
        member.setPassword(passwordEncoder.encode(memberParam.getPassword()));
        member.setStudentNumber(memberParam.getStudentNumber());
        member.setName(memberParam.getName());
        member.setRole(memberParam.getRole());
        member.setPhoneNumber(memberParam.getPhoneNumber());    
        member.setMajor(memberParam.getMajor());
        member.setGeneration(memberParam.getGeneration());
        member.setGithubUrl(memberParam.getGithubUrl());

        memberRepository.save(member);
    }

}
