package com.gdsc.pknu.backend.controller;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.gdsc.pknu.backend.controller.user.MajorRestController;
import com.gdsc.pknu.backend.domain.major.Major;
import com.gdsc.pknu.backend.service.MajorService;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(MajorRestController.class)
public class MajorRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MajorService majorService;

    @Test
    @DisplayName("학과 목록 불러오기 테스트")
    void get_major_list() throws Exception {

        // 서비스 리턴 값 지정
        List<Major> majors = new ArrayList<>();
        majors.add(Major.builder()
                        .id(1L)
                        .majorName("기린공학과").build());
        majors.add(Major.builder()
                        .id(2L)
                        .majorName("향유고래어학과").build());

        when(majorService.getMajorList()).thenReturn(majors);

        mockMvc.perform(get("/api/major"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.response.majorList[1].majorName").value("향유고래어학과"));
    }

}
