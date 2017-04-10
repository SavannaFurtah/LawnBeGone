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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author c0537794
 */
@Named
@SessionScoped
@ManagedBean
public class JobData {

    private Job currentJob = new Job();
    @Inject
    private JobList jl;
    
    public JobData() {
        
    }

    public String createJob(int creator) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "INSERT INTO jobs (ownerId, pay, title, description, status) VALUES (?,?,?,?,?) ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, creator);
            pstmt.setDouble(2, currentJob.getPay());
            pstmt.setString(3, currentJob.getTitle());
            pstmt.setString(4, currentJob.getDescription());
            pstmt.setString(5, "Posted");
            pstmt.executeUpdate();
            Job job = new Job(creator, currentJob.getPay(), currentJob.getTitle(), currentJob.getDescription(), "Posted");
            jl.getJobList().add(job);
            return "JobList";
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("postJobForm", new FacesMessage("Error: Database error."));
        return "PostJob";
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }

    
}
