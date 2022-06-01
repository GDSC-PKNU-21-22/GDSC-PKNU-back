package com.gdsc.pknu.backend.domain.member;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Major {
    @Id
    @GeneratedValue
    @Column(name = "major_id")
    private Long id;

    private String majorName;
}
