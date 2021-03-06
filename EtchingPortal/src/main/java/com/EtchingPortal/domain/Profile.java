package com.EtchingPortal.domain;


import java.util.Date;
import java.util.List;

public class Profile implements java.io.Serializable {

    private Integer id;
    private Integer candidateId;
    private String name, surName, curriculum, category, location, training, experience, languages;
    private Date created;
    private Date modified;

    public Profile() {
    }

    public Profile(Integer candidateId, String curriculum) {
        this.candidateId = candidateId;
        this.curriculum = curriculum;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCandidateId() {
        return this.candidateId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return this.surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getCurriculum() {
        return this.curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTraining() {
        return this.training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
