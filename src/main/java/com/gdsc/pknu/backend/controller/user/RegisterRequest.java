package com.gdsc.pknu.backend.controller.user;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String studentNumber;
    private Long majorId;
    private String phoneNumber;
    private int generation;
    private String imagePath;
    private String githubUrl;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("name", name)
                .append("email", email)
                .append("password", password)
                .append("studentNumber", studentNumber)
                .append("majorId", majorId)
                .append("phoneNumber", phoneNumber)
                .append("generation", generation)
                .append("imagePath", imagePath)
                .append("githubUrl", githubUrl)
                .toString();
    }

}
