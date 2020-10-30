package com.searchservice.mentordetails.service;

import com.searchservice.mentordetails.entity.MentorCalender;
import com.searchservice.mentordetails.repository.MentorCalenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorCalenderService implements MentorCalenderServiceInt{

    @Autowired
    MentorCalenderRepository mentorCalenderRepository;



    public void createMentorCalender(MentorCalender mentorCalender) {
        mentorCalenderRepository.save(mentorCalender);

    }


    public List<MentorCalender> getMentorCalender() {
        return mentorCalenderRepository.findAll();
    }


    public List<MentorCalender> findByMentorId(String mid) {
     return mentorCalenderRepository.findByMid(mid);
    }
}
