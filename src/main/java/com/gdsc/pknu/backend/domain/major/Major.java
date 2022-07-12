package com.gdsc.pknu.backend.domain.major;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Major {
    @Id
    @GeneratedValue
    @Column(name = "major_id")
    private Long id;
    private String majorName;
}
