package com.searchservice.mentordetails.service;

import com.searchservice.mentordetails.entity.MentorSkills;

import java.util.List;

public interface MentorSkillsServiceInt {
    public void createMentorSkill(MentorSkills mentorSkills);
    public List<MentorSkills> getMentorSkill();
    public List<MentorSkills> findBySkillId(String sid);
    public List<MentorSkills> gettableusername();
    public MentorSkills update(MentorSkills mentorSkills , long l);
    public List<MentorSkills> findByMid(String mid);


    public MentorSkills findById(Long id);
}
