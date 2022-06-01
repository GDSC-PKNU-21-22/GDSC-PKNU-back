package com.gdsc.pknu.backend.domain.member;

import javax.persistence.*;

import com.gdsc.pknu.backend.domain.authentication.Jwt;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.h2.mvstore.DataUtils.checkArgument;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
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

    private Long majorId;

    private int generation;

    private String imagePath;

    private String githubUrl;

    private String certfilePath;

    private boolean isCertified;


    protected Member(
            Email email, String password, String studentNumber,
            String name, String phoneNumber, Long majorId,
            Role role, String imagePath, String githubUrl) {

        checkArgument(email != null, "email  must be provided");
        checkArgument(isNotEmpty(password), "password must be provided");
        checkArgument(isNotEmpty(studentNumber), "studentNumber must be provided");
        checkArgument(isNotEmpty(name), "name must be provided");
        checkArgument(majorId != null, "majorId must be provided");
        checkArgument(role != null, "role must be provided");

        this.email = email;
        this.password = password;
        this.studentNumber = studentNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.majorId = majorId;
        this.role = role;
        this.imagePath = imagePath;
        this.githubUrl = githubUrl;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public String generateApiToken(Jwt jwt, String[] roles) {
        Jwt.Claims claims = Jwt.Claims.of(id, email,roles);
        return jwt.generateToken(claims);
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("name", name)
                .append("studentNumber", studentNumber)
                .append("email", email)
                .append("role", role)
                .toString();
    }
}
