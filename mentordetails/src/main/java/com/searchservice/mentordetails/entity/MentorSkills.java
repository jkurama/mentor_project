package com.searchservice.mentordetails.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mentor_skills")
public class MentorSkills implements Serializable {
    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mentor_id")
    private String mid;

    @Column(name = "skill_id")
    private String sid;

    @Column(name = "self_Rating")
    private float selfrating;

    @Column(name = "years_of_experience")
    private int years;

    @Column(name = "trainings_deliverd")
    private int numberoftrainings;

    @Column(name = "facilities_offered")
    private String facilities;

    @Column(name = "mentor_username")
    private String musername;

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public float getSelfrating() {
        return selfrating;
    }

    public void setSelfrating(float selfrating) {
        this.selfrating = selfrating;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getNumberoftrainings() {
        return numberoftrainings;
    }

    public void setNumberoftrainings(int numberoftrainings) {
        this.numberoftrainings = numberoftrainings;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}

/*"mid":
  "sid":
  "selfrating":
  "years":
  "numberoftrainings":
  "facilities":



 */

