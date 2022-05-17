package com.gdsc.pknu.backend.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    
    @Id
    private String studentNumber;
    private String name;
    private String role;
    private String phoneNumber;
    private String major;
    private int generation;
    private String imagePath;
    private String github;
    private String certfilePath;
    
}
