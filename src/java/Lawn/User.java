/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

/**
 *
 * @author c0538434
 */
public class User {

    private int id;
    private String email, hashedPassword;
    private String firstName, lastName;
    private String address, city, province, country, postalCode;

    /**
     * empty user constructor
     */
    public User() {
    }

    /**
     * User constructor accepts all parameters and points to each
     *
     * @param id
     * @param email
     * @param hashedPassword
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param province
     * @param country
     * @param postalCode
     */
    public User(int id, String email, String hashedPassword, String firstName, String lastName, String address, String city, String province, String country, String postalCode) {
        this.id = id;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }

    /**
     * getId method returns the id
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * setId method accepts the id and points to the id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getEmail method returns the email
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail accepts the email and points the the email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getHashedPassword method gets the hashedPassword and
     *
     * @return it
     */
    public String getHashedPassword() {
        return hashedPassword;
    }

    /**
     * setHashedPassword accepts the hashedPassword and points to the it
     *
     * @param hashedPassword
     */
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    /**
     * getFirstName method gets the firstName and returns it
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setFirstName accepts the firstName and points to it
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * getLastName method gets the lastName and returns it
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setLastName accepts the lastName and points to it
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * getAddress method gets the address and returns it
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * setAddress accepts the address and points to it
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * getCity method gets the city and returns it
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * setCity accepts the city and points to it
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * getProvince method gets the province and returns it
     *
     * @return
     */
    public String getProvince() {
        return province;
    }

    /**
     * setProvince accepts the province and points to it
     *
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * getCountry gets the country and returns it
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * setCountry accepts the country and points to it
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * getPostalCode gets the postalCode and returns it
     *
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * setPostalCode accepts the postalCode and points to it
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
