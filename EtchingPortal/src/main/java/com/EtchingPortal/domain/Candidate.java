package com.EtchingPortal.domain;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Candidate implements Serializable  {

    private Integer id;
    private String userName;
    private String passWord;
    private String email;
    private Date lastLogin;
    private Date created;
    private Date modified;

    public Candidate() {
    }

    public Candidate(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Candidate(String userName, String passWord, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
    }
@Id
@GeneratedValue
@Column(name="id")
    /**
     *
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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
    @Override
    public String toString(){
        return "Candidato id: " + getId() + ",first name: " + getUserName();
    }
}
