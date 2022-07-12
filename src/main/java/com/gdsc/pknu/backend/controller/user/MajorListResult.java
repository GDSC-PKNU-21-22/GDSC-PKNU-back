package com.gdsc.pknu.backend.controller.user;

import java.util.List;
import com.gdsc.pknu.backend.domain.major.Major;
import lombok.Getter;

@Getter
public class MajorListResult {

    private List<Major> majorList;

    public MajorListResult(List<Major> majorList) {
        this.majorList = majorList;
    }
}