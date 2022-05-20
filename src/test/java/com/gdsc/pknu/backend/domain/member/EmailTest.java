package com.gdsc.pknu.backend.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {

    @ParameterizedTest
    @DisplayName("메일 형식 테스트")
    @ValueSource(strings = {
            "testnaver.com",
            "@naver.com"
    })
    void invalid_email_form(String address){
        System.out.println(address);
        assertThatThrownBy(()->{
            new Email(address);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("메일 형식 테스트")
    void email_create_test(){
        Email email = new Email("test@naver.com");
    }
}