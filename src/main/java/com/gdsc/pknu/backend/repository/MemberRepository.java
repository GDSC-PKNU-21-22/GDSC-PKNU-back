package com.gdsc.pknu.backend.repository;

import com.gdsc.pknu.backend.data.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByStudentNumber(String s_num);

    Optional<Member> findByEmail(String email);

}
