package com.searchservice.mentordetails.model;

import javax.persistence.Column;

public class MentorTable1 {
    private Long id;


    private String username;


    private String mentorid;




    private String regdatetime;


    private int years;


    private String regcode;



    private String active;

    public String getRegdatetime() {
        return regdatetime;
    }

    public void setRegdatetime(String regdatetime) {
        this.regdatetime = regdatetime;
    }


    public Long getId() {
        return id;
    }

    public String getMentorid() {
        return mentorid;
    }

    public void setMentorid(String mentorid) {
        this.mentorid = mentorid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getRegcode() {
        return regcode;
    }

    public void setRegcode(String regcode) {
        this.regcode = regcode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
