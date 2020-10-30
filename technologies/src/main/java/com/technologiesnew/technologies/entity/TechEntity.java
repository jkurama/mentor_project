package com.technologiesnew.technologies.entity;

import javax.persistence.*;

@Entity
@Table(name = "TECH_AVAILABLE")
public class TechEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tech_name")
    private String techname;

    @Column(name = "techid")
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

    @Column(name = "contents")
    private String contents;

    @Column(name = "E.A.T")
    private int eat;

    @Column(name = "slot")
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

/*
"techname":
"tid":
"contents":
"eat":
"slot":
 */