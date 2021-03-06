package com.EtchingPortal.domain;


import java.util.Date;


public class Inscription implements java.io.Serializable {

    private Integer id;
    private int candidateId;
    private int jobId;
    private String jobTitle, candidateName,status;
    private Date created;
    private Date modified;

    public Inscription() {
    }

    public Inscription(int candidateId, String candidateName, String jobTitle, int jobId, Date created, Date modified) {
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.created = created;
        this.modified = modified;
        this.candidateName = candidateName;
        this.jobTitle = jobTitle;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCandidateName() {
        return this.candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getCandidateId() {
        return this.candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getJobId() {
        return this.jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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
