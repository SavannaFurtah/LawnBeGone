/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author c0538434
 */
@Named
@Singleton
public class JobList {

    private List<Job> jobList = new ArrayList<>();
    private List<Job> jobList2 = new ArrayList<>();

    public List<Job> getJobList2() {
        return jobList2;
    }

    public void setJobList2(List<Job> jobList2) {
        this.jobList2 = jobList2;
    }
    
    public JobList() {
        
    }
    
    /**
     * This method runs when the server is up and running, ensuring that
     * it only runs a single time. Loads up the job list into memory.
     */
    @PostConstruct
    void init() {
        System.out.println("JobList init complete, refreshing job list.");
        refreshJobList();
    }
    
    public String refreshJobList() {
        try (Connection conn = (Connection) DBUtils.getConnection()) {
            String sql = "SELECT * FROM jobs";
            jobList = new ArrayList<>();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Job j = new Job(
                        rs.getInt("id"),
                        rs.getInt("ownerId"),
                        rs.getInt("cutterId"),
                        rs.getDouble("pay"),
                        rs.getString("scheduledDate"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"));
                jobList.add(j);
                
            }
            return "JobList";
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            jobList = new ArrayList<>();
        }
        return null;
    }
        
    public String methodThree(int id) throws SQLException {
    sortByOwnerId(id);
    sortByCutterId(id);
    return "ManageJobs";
}
    
    public void sortByOwnerId(int id) throws SQLException {
        try {
            Connection conn = (Connection) DBUtils.getConnection();
            String sql = "SELECT * FROM jobs WHERE ownerId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);            
            jobList = new ArrayList<>();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Job j = new Job(
                        rs.getInt("id"),
                        rs.getInt("ownerId"),
                        rs.getInt("cutterId"),
                        rs.getDouble("pay"),
                        rs.getString("scheduledDate"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"));
                jobList.add(j);    
            }   
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            jobList = new ArrayList<>();
        }
    }
    
     public void sortByCutterId(int id) throws SQLException {
        try {
            Connection conn = (Connection) DBUtils.getConnection();
            String sql = "SELECT * FROM jobs WHERE cutterId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);          
            jobList2 = new ArrayList<>();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Job j2 = new Job(
                        rs.getInt("id"),
                        rs.getInt("ownerId"),
                        rs.getInt("cutterId"),
                        rs.getDouble("pay"),
                        rs.getString("scheduledDate"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status"));
                jobList2.add(j2);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            jobList2 = new ArrayList<>();
        }
    }
    
    public Job getJobById(int targetId) {
        for (Job j : jobList) {
            if (j.getId() == targetId)
                return j;
        }
        return null;
    }
    
    public void removeJobById(int targetId) {
        jobList.remove(this.getJobById(targetId));
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
    
    
}
