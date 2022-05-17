package com.gdsc.pknu.backend.repository;

import com.gdsc.pknu.backend.data.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
