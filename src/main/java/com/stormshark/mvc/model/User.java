package com.stormshark.mvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class User {



    public UUID id;
    public String name;
    public String lastname;
    public String code;
    public String email;
    public Date birthdate;
    public String password;
    public JsonProperty passwordHistory;

    public User(UUID id, String name, String lastname, String code, String email, Date birthdate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.code = code;
        this.email = email;
        this.birthdate = birthdate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public JsonProperty getPasswordHistory() {
        return passwordHistory;
    }

    public void setPasswordHistory(JsonProperty passwordHistory) {
        this.passwordHistory = passwordHistory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    public String getLastname() {
        return lastname;
    }






}
