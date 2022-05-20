package com.gdsc.pknu.backend.dto;

import lombok.Data;

@Data
public class MemberParam {

    private String email;
    private String password;
    private String studentNumber;
    private String name;
    private String role;
    private String phoneNumber;
    private String major;
    private int generation;
    private String githubUrl;

}
