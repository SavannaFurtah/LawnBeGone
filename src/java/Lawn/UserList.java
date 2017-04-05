/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author c0538434
 */
@Named
@Singleton
public class UserList {
    private List<User> userList = new ArrayList<>();
    private int nextUserId = 0;
    
    public UserList() {
        
    }
    
    public boolean userExistsByEmail(String targetEmail) {
        for (User u : userList) {
            if (targetEmail.toLowerCase().equals(u.getEmail().toLowerCase()))
                return true;
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getNextUserId() {
        return nextUserId;
    }

    public void setNextUserId(int nextUserId) {
        this.nextUserId = nextUserId;
    }
    
    
}
