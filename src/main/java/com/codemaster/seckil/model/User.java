package com.codemaster.seckil.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {


    private static final long serialVersionUID = 5371500855041561834L;

    @Id
    @Column(name = "username")
    @NotBlank(message = "username can not be null")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "password can not be null")
    private String password;

    @Column(name = "id",nullable = false)
    private long id;

    @Column(name = "dbflag")
    private String dbflag;

    private String repassword;

    public void setId(long id) {
        this.id = id;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }


    public String getDbflag() {
        return dbflag;
    }

    public void setDbflag(String dbflag) {
        this.dbflag = dbflag;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
