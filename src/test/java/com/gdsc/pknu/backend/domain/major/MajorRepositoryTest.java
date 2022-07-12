package com.gdsc.pknu.backend.domain.major;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MajorRepositoryTest{
    
    @Autowired
    private MajorRepository majorRepository;

    @Test
    @DisplayName("학과 정보 리스트 불러오기")
    void get_major_list(){
        // given

        // when
           List<Major> majors = majorRepository.findAll();
        // then
            assert(majors.size() == 79);
            assert(majors.get(78).getMajorName().equals("공공안전경찰학과"));
    }
}
