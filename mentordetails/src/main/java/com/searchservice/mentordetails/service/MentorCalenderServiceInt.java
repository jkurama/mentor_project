package com.searchservice.mentordetails.service;

import com.searchservice.mentordetails.entity.MentorCalender;

import java.util.List;

public interface MentorCalenderServiceInt {
    public void createMentorCalender(MentorCalender mentorCalender);
    public List<MentorCalender> getMentorCalender();
    public List<MentorCalender> findByMentorId(String mid);

}
