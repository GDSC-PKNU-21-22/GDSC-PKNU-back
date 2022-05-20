package com.gdsc.pknu.backend.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Member {
    @Id
    private int userId;
    private String studentNumber;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private String major;
    private int generation;
    private String imagePath;
    private String githubUrl;
    private String certfilePath;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGithub() {
        return githubUrl;
    }

    public void setGithub(String github) {
        this.githubUrl = github;
    }

    public String getCertfilePath() {
        return certfilePath;
    }

    public void setCertfilePath(String certfilePath) {
        this.certfilePath = certfilePath;
    }
}
