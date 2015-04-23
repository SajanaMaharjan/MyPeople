/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ashok Subedi
 */
@Entity
public class MyPeopleMember implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private String userName;
    private String firstName;
    private String lastName;

//    @Temporal(TemporalType.DATE)
//    private String dob;
    private String street;
    private String city;
    private String state;
//    private String homeCity;
//    private String gender;
    private String contactNumber;
    private String email;
    private String password;
//    private String role="MEMBER";
//    private String conPassword;

//    private String imageName;
    public MyPeopleMember() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//    public String getHomeCity() {
//        return homeCity;
//    }
//
//    public void setHomeCity(String homeCity) {
//        this.homeCity = homeCity;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    /**
     *
     * @param password
     */
    public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        this.password = digest.digest(password.getBytes("UTF-8")).toString();

        
//        this.password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(password);
//        this.password = password;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

//    public String getImageName() {
//        return imageName;
//    }
//
//    public void setImageName(String imageName) {
//        this.imageName = imageName;
//    }
//    public String getConPassword() {
//        return conPassword;
//    }
//
//    public void setConPassword(String conPassword) {
//        this.conPassword = conPassword;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyPeopleMember)) {
            return false;
        }
        MyPeopleMember other = (MyPeopleMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mypeople.entity.Member[ id=" + id + " ]";
    }

}
