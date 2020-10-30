package com.searchservice.mentordetails.repository;

import com.searchservice.mentordetails.entity.MentorTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorTableRepository extends JpaRepository<MentorTable,Long> {

    MentorTable findByUsername(String username);
    MentorTable findByMentorid(String mentorid);
}
