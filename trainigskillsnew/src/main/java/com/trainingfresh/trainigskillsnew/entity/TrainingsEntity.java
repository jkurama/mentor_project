package com.trainingfresh.trainigskillsnew.entity;

import javax.persistence.*;

@Entity
@Table(name = "Training_Details")
public class TrainingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Mentor_Id")
    private String mid;

    @Column(name = "User_id")
    private String userId;

    @Column(name = "Skill_id")
    private String sid;

    @Column(name = "Status")
    private String status;

    @Column(name = "Progress")
    private int progress;


    @Column(name = "Rating")
    private float rating;

    @Column(name = "Start_date")
    private String startdate;

    @Column(name = "End_date")
    private String enddate;

    @Column(name = "Slot")
    private String slot;

    @Column(name = "Amount")
    private long amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

/*
"mid":
"userId":
"sid":
"status":
"progress":
"rating":
"startdate":
"endate":
"slot":
"amount":

 */
