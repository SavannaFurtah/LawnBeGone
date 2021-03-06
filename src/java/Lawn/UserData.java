/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * This bean manages the user's functions for the session
 *
 * @author c0538434
 */
@Named
@SessionScoped
@ManagedBean
public class UserData {

    private List<User> users = new ArrayList<>();

    private User currentUser = new User();
    private String password;
    private int nextUserId;
    @Inject
    private UserList ul;
    private boolean loggedIn = false;

    /**
     * empty userData constructor
     */
    public UserData() {

    }

    /**
     * getUsers method gets the user list
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * setUsers accepts the list of users and points to it
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * getById gets the userList by the id and returns it
     *
     * @param id
     * @return
     */
    public User getById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    /**
     * Creates a user in the database
     *
     * @return The page to redirect to.
     */
    public String createUser() {
        currentUser.setHashedPassword(hashPass(password));
        try (Connection conn = (Connection) DBUtils.getConnection()) {
            String sql = "INSERT INTO users (email, hashedPassword) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, currentUser.getEmail());
            pstmt.setString(2, currentUser.getHashedPassword());
            pstmt.executeUpdate();
            ul.addToUserList(currentUser);
            loggedIn = true;
            return "index";
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, "Test", ex);
            currentUser = new User();
            return "UserRegistration";
        }
    }

    /**
     * Log a user in, produces an error if necessary
     *
     * @return Redirect to index on success, stay on page if failure
     */
    public String loginUser() {
        currentUser.setHashedPassword(hashPass(password));
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (ul.verifyCredentials(currentUser.getEmail(), currentUser.getHashedPassword())) {
            currentUser = ul.getUserByEmail(currentUser.getEmail());
            System.out.println("Got user " + currentUser.getId() + ": " + currentUser.getEmail());
            loggedIn = true;
            return "JobList";
        }
        facesContext.addMessage("loginForm", new FacesMessage("Username or Password is incorrect."));
        return null;
    }

    /**
     * Logs user out of the site
     *
     * @return Redirect to index
     */
    public String logoutUser() {
        currentUser = new User();
        loggedIn = false;
        return "index";
    }

    /**
     * This only sort of belongs in this scope but go ahead, call the cops, they
     * can't un-wrong-scope it.
     *
     * @param pw The password to salt and hash
     * @return Salted and Hashed password
     */
    public String hashPass(String pw) {
        final String SALT = "HEREcomesThe246SALTforThePasswordsToBeSecure";
        try {
            String salted = pw + SALT;
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] hash = md.digest(salted.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(b & 0xff).toUpperCase();
                if (hex.length() == 1) {
                    sb.append("0");
                }
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //Getters & Setters
    /**
     * getCurrentUser gets the user
     *
     * @return the currentUser
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * setCurrentUser accepts the currentUser
     *
     * @param currentUser points to the currentUser
     */
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    /**
     * getPassword gets the password
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword accepts the password
     *
     * @param password points to the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getNextUserId gets the nextUserId
     *
     * @return the nextUserId
     */
    public int getNextUserId() {
        return nextUserId;
    }

    /**
     * setNextUserId accepts the nextUserId
     *
     * @param nextUserId points to the nextUserId
     */
    public void setNextUserId(int nextUserId) {
        this.nextUserId = nextUserId;
    }

    /**
     * getUl gets the userList
     *
     * @return the userList
     */
    public UserList getUl() {
        return ul;
    }

    /**
     * setUl accepts the userList
     *
     * @param ul points to userList
     */
    public void setUl(UserList ul) {
        this.ul = ul;
    }

    /**
     * isLogged in determines if the user is logged in
     *
     * @return true if user is logged in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * setLoggedIn accepts the true loggedIn
     *
     * @param loggedIn points to the loggedIn
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    /**
     * edit method
     *
     * @return the editUser page
     */
    public String edit() {
        return "editUser";
    }

    /**
     * saveUser method saves the changed user info to the database
     *
     * @return to the job list page
     */
    public String saveUser() {
        try (Connection conn = DBUtils.getConnection()) {
            if (currentUser.getId() >= 0) {
                String sql = "UPDATE users SET first_name = ?, last_name = ?, address = ?, city = ?, province = ?, country = ?, postal_code = ? WHERE id = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, currentUser.getFirstName());
                pstmt.setString(2, currentUser.getLastName());
                pstmt.setString(3, currentUser.getAddress());
                pstmt.setString(4, currentUser.getCity());
                pstmt.setString(5, currentUser.getProvince());
                pstmt.setString(6, currentUser.getCountry());
                pstmt.setString(7, currentUser.getPostalCode());
                pstmt.setInt(8, currentUser.getId());
                pstmt.executeUpdate();
                return "JobList";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Login";
    }

}
