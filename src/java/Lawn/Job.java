/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lawn;

import java.sql.Date;

/**
 *
 * @author c0538434
 */
public class Job {

    private int id, ownerId, cutterId;
    private double pay;
    private String scheduledDate;

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = scheduledDate;
    }
    private String title, description, status;

    /**
     * Empty job constructor
     */
    public Job() {
    }

    /**
     * Job constructor with each parameter 
     * @param owner
     * @param pay
     * @param title
     * @param description
     * @param status 
     */
    public Job(int owner, double pay, String title, String description, String status) {
        this.ownerId = owner;
        this.pay = pay;
        this.title = title;
        this.description = description;
        this.status = status;
    }
  
    /**
     * Job constructor 
     * @param id
     * @param owner
     * @param cutter
     * @param pay
     * @param scheduledDate
     * @param title
     * @param description
     * @param status 
     */
    public Job(int id, int owner, int cutter, double pay, Date scheduledDate, String title, String description, String status) {
        this.id = id;
        this.ownerId = owner;
        this.cutterId = cutter;
        this.pay = pay;
        this.scheduledDate = scheduledDate;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    /**
     * getId method gets job id and returns the job id
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * setId method sets the job id 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getOwner method gets the ownerId and returns the ownerId
     * 
     * @return 
     */
    public int getOwner() {
        return ownerId;
    }

    /**
     * setOwner method sets the ownerId to the job
     * @param owner 
     */
    public void setOwner(int owner) {
        this.ownerId = owner;
    }

    /**
     * getCutter method gets the cutterId and returns it for the job
     * @return 
     */
    public int getCutter() {
        return cutterId;
    }

    /**
     * setCutter method sets the cutterId to the job
     * @param cutter 
     */
    public void setCutter(int cutter) {
        this.cutterId = cutter;
    }

    /**
     * getPay method gets the pay amount and returns the pay for the job
     * @return 
     */
    public double getPay() {
        return pay;
    }

    /**
     * setPay method sets the pay for the job
     * @param pay 
     */
    public void setPay(double pay) {
        this.pay = pay;
    }
  
    /**
     * the getScheduledDate method gets the scheduledDate and returns it
     * @return 
     */
    public Date getScheduledDate() {
        return scheduledDate;
    }

    /**
     * setScheduledDate method sets the date for the job
     * @param scheduledDate 
     */
    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }


    /**
     * getTitle method gets the title for the job and returns the title
     * @return 
     */
    public String getTitle() {
        return title;
    }

    /**
     * setTitle method sets the title for the job
     * @param title 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getDescription method gets the description for the job
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription method sets the description of the job
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * getStatus method gets the status for the job 
     * @return 
     */
    public String getStatus() {
        return status;
    }

    /**
     * setStatus method sets the status
     * @param status 
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
