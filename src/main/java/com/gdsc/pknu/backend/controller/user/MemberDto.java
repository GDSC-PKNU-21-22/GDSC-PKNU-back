package com.gdsc.pknu.backend.controller.user;

import com.gdsc.pknu.backend.domain.member.Email;
import com.gdsc.pknu.backend.domain.member.Member;
import com.gdsc.pknu.backend.domain.member.Role;
import lombok.Getter;
import lombok.Setter;


import static org.springframework.beans.BeanUtils.copyProperties;

@Getter @Setter
public class MemberDto {
    private Long id;
    private String name;
    private Email email;
    private String studentNumber;
    private Role role;
    private String phoneNumber;
    private Long majorId;
    private int generation;
    private String imagePath;
    private String githubUrl;

    public MemberDto(Member member){
        copyProperties(member, this);
    }
}
