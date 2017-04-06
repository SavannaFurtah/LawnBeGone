/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * The singleton that holds the user list and user list accessories.
 * @author c0538434
 */
@Named
@Singleton
public class UserList {

    private List<User> userList = new ArrayList<>();

    public UserList() {
    }

    /**
     * Looks through the list of users to find if the email matches
     * @param targetEmail The email address to look for (case insensitive)
     * @return True if an email matches, false if none do
     */
    public boolean userExistsByEmail(String targetEmail) {
        for (User u : userList) {
            if (targetEmail.toLowerCase().equals(u.getEmail().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Causes the application to query the database and load all users into
     * local memory. Should probably only be run on post-initialization but
     * hey, I'm a JavaDoc, not a cop.
     */
    public void refreshUserList() {
        try (Connection conn = (Connection) DBUtils.getConnection()) {
            String sql = "SELECT * FROM users";
            userList = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("hashedPassword"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("country"),
                        rs.getString("postal_code"));
                userList.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            userList = new ArrayList<>();
        }
    }
    
    public void addToUserList(User u) {
        userList.add(u);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    /**
     * This method runs when the server is up and running, ensuring that
     * it only runs a single time. Loads up the user list into memory.
     */
    @PostConstruct
    void init() {
        System.out.println("UserList init complete, refreshing user list.");
        refreshUserList();
    }

}
