/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Date;

/**
 *
 * @author c0656308
 */
public class LawnCutter {
    private int cutterId;
    private String firstName;
    private String lastName;
    private int SocInsNum;
    private String address;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private Date birthday;

    public LawnCutter(int cutterId, String firstName, String lastName, int SocInsNum, String address, String city, String province, String country, String postalCode, String phoneNumber, String email, Date birthday) {
        this.cutterId = cutterId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.SocInsNum = SocInsNum;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.birthday = birthday;
    }

    public LawnCutter() {
    }

    public int getCutterId() {
        return cutterId;
    }

    public void setCutterId(int cutterId) {
        this.cutterId = cutterId;
    }

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

    public int getSocInsNum() {
        return SocInsNum;
    }

    public void setSocInsNum(int SocInsNum) {
        this.SocInsNum = SocInsNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
}
