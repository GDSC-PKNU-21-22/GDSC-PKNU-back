package com.gdsc.pknu.backend.controller.user;

import com.gdsc.pknu.backend.controller.ApiRes;
import com.gdsc.pknu.backend.domain.authentication.Jwt;
import com.gdsc.pknu.backend.domain.member.Email;
import com.gdsc.pknu.backend.domain.member.Member;
import com.gdsc.pknu.backend.domain.member.MemberRepository;
import com.gdsc.pknu.backend.domain.member.Role;
import com.gdsc.pknu.backend.service.MemberService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MemberRestController.class)
class MemberRestControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    MemberService memberService;

    @MockBean
    Jwt jwt;

    @Test
    @DisplayName("MemberRestControllerTest")
    void register() throws Exception {
        // given
        RegisterRequest reg = RegisterRequest.builder()
                .email("gdsc@gmail.com")
                .password("asdfgdsc")
                .name("최정은")
                .studentNumber("202012345")
                .majorId(1L)
                .phoneNumber("01012345678")
                .generation(1)
                .imagePath("asdfghjk")
                .githubUrl("pkgdsc123")
                .build();

        Member member = Member.builder()
                .email(new Email(reg.getEmail()))
                .id(1L)
                .password(reg.getPassword())
                .studentNumber(reg.getStudentNumber())
                .name(reg.getName())
                .phoneNumber(reg.getPhoneNumber())
                .majorId(reg.getMajorId())
                .imagePath(reg.getImagePath())
                .githubUrl(reg.getGithubUrl())
                .build();

        String token = member.generateApiToken(jwt, new String[]{"ROLE_USER"});

        // when
        ApiRes apiRes = ApiRes.SUCCESS(new RegisterResult(new MemberDto(member), token));

        // then
        assertEquals(true, apiRes.isSuccess());

//        // given
//        RegisterRequest reg = RegisterRequest.builder()
//                .email("gdsc@gmail.com")
//                .password("asdfgdsc")
//                .name("최정은")
//                .studentNumber("202012345")
//                .majorId(1L)
//                .phoneNumber("01012345678")
//                .generation(1)
//                .imagePath("asdfghjk")
//                .githubUrl("pkgdsc123")
//                .build();
//         Gson gson = new GsonBuilder().create();
//         String registerRequest = gson.toJson(reg);
//
//        // when
//        this.mvc.perform(post("/")
//                        .contentType(MediaType.MULTIPART_FORM_DATA)
//                        .content(registerRequest))
//                // then
//                .andExpect(jsonPath("success", true).exists());
    }
}