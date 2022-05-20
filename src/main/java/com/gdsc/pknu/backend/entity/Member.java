package com.gdsc.pknu.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    
    @Id
    private int userId;
    private String email;
    private String password;
    private String studentNumber;
    private String name;
    private String role;
    private String phoneNumber;
    private String major;
    private int generation;
    private String imagePath;
    private String githubUrl;
    private String certfilePath;
    private int isCertified;

}
