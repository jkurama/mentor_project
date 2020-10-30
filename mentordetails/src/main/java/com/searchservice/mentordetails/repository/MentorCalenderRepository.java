package com.searchservice.mentordetails.repository;

import com.searchservice.mentordetails.entity.MentorCalender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorCalenderRepository extends JpaRepository<MentorCalender,Long> {

    List<MentorCalender> findByMid(String mid);

}
