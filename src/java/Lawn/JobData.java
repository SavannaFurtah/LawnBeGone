/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author c0537794
 */
public class JobData {
    private List<Job> jobList = new ArrayList<>();
    private Job currentJob = new Job();

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }
        public String addJob() {
        try{
            Connection conn = DBUtils.getConnection();
            String sql = "INSERT INTO jobs (id, pay, scheduledDate, status) VALUES (?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,currentJob.getId());
            pstmt.setDouble(2,currentJob.getPay());
            pstmt.setDate(3, currentJob.getScheduledDate());
            pstmt.setString(4, currentJob.getStatus());
            pstmt.executeUpdate();
            jobList.add(currentJob);
            currentJob = new Job();
            
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "jobList";
    }
    
}
