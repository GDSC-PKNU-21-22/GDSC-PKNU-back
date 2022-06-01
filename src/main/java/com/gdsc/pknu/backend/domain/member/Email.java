package com.gdsc.pknu.backend.domain.member;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {

    @Transient
    private final Pattern pattern = Pattern.compile("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+");

    @Column(name = "email")
    private String address;

    protected Email() {}

    public Email(String address) {
        validate(address);
        this.address = address;
    }

    private void validate(String address){
        Matcher matcher = pattern.matcher(address);
        if(!matcher.matches()){
            throw new IllegalArgumentException("잘못된 메일 형식입니다.");
        }
    }

    public String getAddress() {
        return address;
    }
}
