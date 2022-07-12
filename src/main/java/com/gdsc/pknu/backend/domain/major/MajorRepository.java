package com.gdsc.pknu.backend.domain.major;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
    List<Major> findAll();
} 