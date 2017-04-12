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

    public Job() {
    }

    public Job(int owner, double pay, String title, String description, String status) {
        this.ownerId = owner;
        this.pay = pay;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Job(int id, int owner, int cutter, double pay, String scheduledDate, String title, String description, String status) {
        this.id = id;
        this.ownerId = owner;
        this.cutterId = cutter;
        this.pay = pay;
        this.scheduledDate = scheduledDate;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner() {
        return ownerId;
    }

    public void setOwner(int owner) {
        this.ownerId = owner;
    }

    public int getCutter() {
        return cutterId;
    }

    public void setCutter(int cutter) {
        this.cutterId = cutter;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
