/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author c0537794
 */
@Named
@SessionScoped
@ManagedBean
public class JobData {

    private Job currentJob = new Job();
    
    private User currentOwner = new User();
    
    private User jobOwner = new User();
    
    @Inject
    private JobList jl;
    
    public JobData() {
        
    }
    
    
    /**
     * Takes info from creating a job, adds it to the database, and adds it to
     * the job list for browsing.
     * @param creator The User id of the job poster
     * @return A page redirect to JobList on success, error message on failure
     */
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
        return null;
    }

    /**
     * Edits a job to assign a User id as the person who will be performing the
     * job and adding the due date.
     * @param jobId The Job ID to be edited
     * @param cutterID The user being assigned to the job
     * @param date The day, month, and year scheduled (dd/mm/yy)
     * @param time The time scheduled (hh:mm:ss with hh being 24 hour time, 1-24)
     * @return Redirects to the job management page
     * @throws ParseException 
     */
    public String assignJobToCutter(int jobId, int cutterID, String date) throws ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy'T'kk:mm:ss");
        //Date scheduledDate = (Date) sdf.parse(date);
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "UPDATE jobs SET cutterId = ?, scheduledDate = ?, status = 'Scheduled' WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cutterID);
            pstmt.setString(2, date);
            pstmt.setInt(3, jobId);
            pstmt.executeUpdate();
            Job updatedJob = jl.getJobById(jobId);
            updatedJob.setCutter(cutterID);
            updatedJob.setScheduledDate(date);
            return "JobList";
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("postJobForm", new FacesMessage("Error: Database error."));
        return null;
    }
    
    /**
     * Deletes a job from the list and database
     * @param jobId The job ID to be removed
     * @return a redirect to the Job List
     */
    public String deleteJob(int jobId) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "DELETE FROM jobs WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, jobId);
            pstmt.executeUpdate();
            jl.removeJobById(jobId);
            return "JobList";
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("postJobForm", new FacesMessage("Error: Database error."));
        return null;
    }
    
    /**
     * Removes the cutter from the specified job.
     * @param jobId The job ID to remove a cutter on
     * @return A redirect to the job list
     */
    public String removeCutterFromJob(int jobId) {
        try {
            Connection conn = DBUtils.getConnection();
            String sql = "UPDATE jobs SET cutterId = 0, scheduledDate = null WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, jobId);
            pstmt.executeUpdate();
            Job updatedJob = jl.getJobById(jobId);
            updatedJob.setCutter(0);
            updatedJob.setScheduledDate(null);
            return "JobList";
        } catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("postJobForm", new FacesMessage("Error: Database error."));
        return null;
    }
    
    public String editJob(int jobId) {
        try{
            Connection conn = DBUtils.getConnection();
            String sql = "UPDATE job SET title = ?, description = ?, pay = 0, status = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, currentJob.getTitle());
            pstmt.setString(5,currentJob.getDescription());
            pstmt.setDouble(6,currentJob.getPay());
            pstmt.setString(8,currentJob.getStatus());
            pstmt.setInt(5, currentJob.getId());
            pstmt.executeUpdate();
            return "PostJob";
        }catch (SQLException ex) {
            Logger.getLogger(Job.class.getName()).log(Level.SEVERE, null, ex);
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage("postJobForm", new FacesMessage("Error: Database error"));
        return null;
        
    }
    
    public Job getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }

    public String viewJob(Job job, int owner){
        currentJob = job;
        currentJob.setOwner(owner);     
        return"SelectJob";
    }
}
