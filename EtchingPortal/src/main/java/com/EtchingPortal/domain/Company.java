package com.EtchingPortal.domain;


import java.util.Date;

public class Company implements java.io.Serializable {

    private Integer id;
    private String cif;
    private String name;
    private String passWord;
    private String email;
    private Date lastLogin;
    private Date created;
    private Date modified;

    public Company() {
    }

    public Company(String cif, String name, String passWord) {
        this.cif = cif;
        this.name = name;
        this.passWord = passWord;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCif() {
        return this.cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return this.passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
        public String getEmail() {
        return this.email;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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
}
