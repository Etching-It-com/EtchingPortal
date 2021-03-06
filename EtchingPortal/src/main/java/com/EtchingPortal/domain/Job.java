package com.EtchingPortal.domain;


import java.util.Date;


public class Job implements java.io.Serializable {

    private Integer id;
    private int companyId;
    private String companyName, title, description, location, category, training, experience, languages;
    private Date created;
    private Date modified;

    public Job() {
    }

    public Job(int companyId, Date created, Date modified) {
        this.companyId = companyId;
        this.created = created;
        this.modified = modified;
    }

    public Job(int companyId, String description, Date created, Date modified) {
        this.companyId = companyId;
        this.description = description;
        this.created = created;
        this.modified = modified;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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
