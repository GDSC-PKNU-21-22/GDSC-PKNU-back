package com.gdsc.pknu.backend.service;

import com.gdsc.pknu.backend.domain.member.Email;
import com.gdsc.pknu.backend.domain.member.Member;
import com.gdsc.pknu.backend.domain.member.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public MemberService(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member register(Member member){
        validateDuplicatedEmail(member.getEmail());
        member.encodePassword(passwordEncoder);
        return memberRepository.save(member);
    }

    private void validateDuplicatedEmail(Email email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if(member.isPresent()){
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }
    }
}
