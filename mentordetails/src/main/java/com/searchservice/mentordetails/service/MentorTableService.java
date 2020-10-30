package com.searchservice.mentordetails.service;

import com.searchservice.mentordetails.entity.MentorTable;
import com.searchservice.mentordetails.repository.MentorTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorTableService implements MentorTableServiceInt {

    @Autowired
    MentorTableRepository mentorTableRepository;


    public void createMentorTable(MentorTable mentorTable) {
        mentorTableRepository.save(mentorTable);

    }

    public List<MentorTable> getMentorTable() {
        return mentorTableRepository.findAll();
    }

    public MentorTable findByUsername(String username) {
        return mentorTableRepository.findByUsername(username);
    }

    public MentorTable update(MentorTable mentorTable, long l) {
        return mentorTableRepository.save(mentorTable);
    }

    public MentorTable findById(Long id) {
        return mentorTableRepository.findById(id).get();
    }

    public MentorTable findByMid(String mentorid) {
        return mentorTableRepository.findByMentorid(mentorid);
    }
}
