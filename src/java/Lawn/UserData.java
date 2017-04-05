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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author c0538434
 */
@Named
@SessionScoped
@ManagedBean
public class UserData {
    private User currentUser = new User();
    private String password;
    private int nextUserId;
    private UserList ul = new UserList();
    private boolean loggedIn = false;
    
    public UserData() {
        
    }
    
    public String createUser() {
        int id = ul.getNextUserId();
        currentUser.setId(id);
        try (Connection conn = (Connection) DBUtils.getConnection()) {
            String sql = "INSERT INTO users (id, email, hashedPassword) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, currentUser.getId());
            pstmt.setString(2, currentUser.getEmail());
            pstmt.setString(3, hashPass(password));
            pstmt.executeUpdate();
            ul.getUserList().add(currentUser);
            loggedIn = true;
            return "index";
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            currentUser = new User();
            return "UserRegistration";
        }
    }
    
    public String hashPass (String pw) {
        final String SALT = "HEREcomesTheSALTforThePasswordsToBeSecure";
        try {
            String salted = pw + SALT;
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] hash = md.digest(salted.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(b & 0xff).toUpperCase();
                if (hex.length() == 1) sb.append("0");
                sb.append(hex);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
