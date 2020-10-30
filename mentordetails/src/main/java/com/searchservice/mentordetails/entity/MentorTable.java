package com.searchservice.mentordetails.entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mentor_Table")
public class MentorTable implements Serializable{
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username" )
    private String username;

    @Column(name = "mentor_id")
    private String mentorid;



    @Column(name = "reg_date_time")
    private String regdatetime;

    @Column(name = "years_of_experience")
    private int years;

    @Column(name = "reg_code")
    private String regcode;


    @Column(name = "active")
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



/*
"username":
"mentorid":
"regdatetime":
"years":
"regcode":
"active":
 */
