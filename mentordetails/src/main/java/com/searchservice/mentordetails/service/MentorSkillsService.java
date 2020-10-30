package com.searchservice.mentordetails.service;

import com.searchservice.mentordetails.entity.MentorSkills;
import com.searchservice.mentordetails.repository.MentorSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorSkillsService implements MentorSkillsServiceInt {
    @Autowired
    MentorSkillsRepository mentorSkillsRepository;

    public void createMentorSkill(MentorSkills mentorSkills) {
         mentorSkillsRepository.save(mentorSkills);

    }

    public List<MentorSkills> getMentorSkill() {

        return mentorSkillsRepository.findAll();
    }



    public List<MentorSkills> findBySkillId(String sid) {
        return mentorSkillsRepository.findBySid(sid);
    }

    public List<MentorSkills> gettableusername() {

        return mentorSkillsRepository.gettable();
    }

//    public List<MentorSkills> findByMentorId() {
//        return mentorSkillsRepository.findByMid();
//    }

    public MentorSkills update(MentorSkills mentorSkills, long l) {
        return mentorSkillsRepository.save(mentorSkills);
    }

    public List<MentorSkills> findByMid(String mid) {
        return mentorSkillsRepository.findByMid(mid);
    }

    public MentorSkills findById(Long id) {
        return mentorSkillsRepository.findById(id).get();
    }
}
