package com.searchservice.mentordetails.service;

import com.searchservice.mentordetails.entity.MentorTable;

import java.util.List;

public interface MentorTableServiceInt {

    public void createMentorTable(MentorTable mentorTable);
    public List<MentorTable> getMentorTable();
    public MentorTable findByUsername(String username);
    public MentorTable update(MentorTable mentorTable , long l);
    public MentorTable findById(Long id);
    public MentorTable findByMid(String mentorid);
}
