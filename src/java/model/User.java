/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author LAPTOP
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String country;
    private String role;
    private boolean status;
    private String password;
    
    private Date dob;

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public User() {
    }
    
    public User(int id, String name, String email, String country, String role,
            boolean status, String password, Date dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.role = role;
        this.status = status;
        this.password = password;
        this.dob = dob;
    }
    public User( String name, String email, String country, String role, boolean
    status, String password, Date dob) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.role = role;
        this.status = status;
        this.dob = dob;
        this.password = password;
    }

    public User(int id, String name, String email, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getCountry() {
        return country;

    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isStatus() {
        return status;
    }   

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", country='" + country + '\'' +
        ", role='" + role + '\'' +
        ", status=" + status +
        ", password='" + password + '\'' +
        '}';
    }
}
