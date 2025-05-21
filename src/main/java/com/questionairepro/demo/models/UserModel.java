package com.questionairepro.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "USERDETAILSTB")
@Table(name="USERDETAILSTB")
public class UserModel {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="USERNAME")
    private String username;
    @Column(name = "EMAIL_STRING")
    private String emailString;
    
    public UserModel(long id, String username, String emailString) {
        this.id = id;
        this.username = username;
        this.emailString = emailString;
    }
    public UserModel(String username, String emailString) {
       
        this.username = username;
        this.emailString = emailString;
    }
    public UserModel() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmailString() {
        return emailString;
    }
    public void setEmailString(String emailString) {
        this.emailString = emailString;
    }
    
    
}
