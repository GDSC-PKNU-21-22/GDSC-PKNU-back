package com.gdsc.pknu.backend.domain.member;

import javax.persistence.*;

import com.gdsc.pknu.backend.domain.authentication.Jwt;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.h2.mvstore.DataUtils.checkArgument;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Embedded
    @Column(unique = true)
    private Email email;

    private String password;

    private String studentNumber;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Role role;

    private String phoneNumber;

    private String major;

    private int generation;

    private String imagePath;

    private String githubUrl;

    private String certfilePath;

    private boolean isCertified;


    protected Member(
            Email email, String password, String studentNumber,
            String name, String phoneNumber, String major,
            Role role, String imagePath, String githubUrl) {

        checkArgument(email != null, "email  must be provided");
        checkArgument(isNotEmpty(password), "password must be provided");
        checkArgument(isNotEmpty(studentNumber), "studentNumber must be provided");
        checkArgument(isNotEmpty(name), "name must be provided");
        checkArgument(isNotEmpty(major), "major must be provided");
        checkArgument(role != null, "role must be provided");

        this.email = email;
        this.password = password;
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.major = major;
        this.role = role;
        this.imagePath = imagePath;
        this.githubUrl = githubUrl;
    }

    public Member(
            Email email, String password, String studentNumber,
            String name, String major, Role role) {
        this(email, password, studentNumber, name, null, major, role, null, null);
    }

    public static Member from(
            Email email, String password, String studentNumber,
            String name, String major, Role role){
       return new Member(email, password, studentNumber, name, major, role);
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public String generateApiToken(Jwt jwt, String[] roles) {
        Jwt.Claims claims = Jwt.Claims.of(id, email,roles);
        return jwt.generateToken(claims);
    }
}
