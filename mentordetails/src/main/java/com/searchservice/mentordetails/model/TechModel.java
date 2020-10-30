package com.searchservice.mentordetails.model;//package com.technologies.techlist.model;
import javax.persistence.*;
//package com.searchservice.mentordetails.model;



public class TechModel {



    private Long id;

    private String techname;

    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    private String contents;

    private int eat;

    private String slot;

    //   @JoinTable(name = "TECH_AVAILABLE",joinColumns = {@JoinColumn(name = tech_id)})

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechname() {
        return techname;
    }

    public void setTechname(String techname) {
        this.techname = techname;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }



}

