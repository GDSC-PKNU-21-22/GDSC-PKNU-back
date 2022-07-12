package com.gdsc.pknu.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gdsc.pknu.backend.domain.major.Major;
import com.gdsc.pknu.backend.domain.major.MajorRepository;

@Service
public class MajorService {
    
    @Autowired
    private final MajorRepository majorRepository;

    public MajorService(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    public List<Major> getMajorList() {
        return majorRepository.findAll();
    }
}
