package com.searchservice.mentordetails.repository;

import com.searchservice.mentordetails.entity.MentorSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface MentorSkillsRepository extends JpaRepository<MentorSkills,Long> {
     List<MentorSkills> findBySid(String sid);

     List<MentorSkills> findByMid(String mid);

  //   @Query(value = "select ms.sid as skillid from MentorSkills ms")
  //   List<Map<String,Object>> findAbc(String skillid);

     @Query(value = "select ms, mt.username from MentorTable mt LEFT JOIN MentorSkills ms ON ms.mid = mt.mentorid")
     public List<MentorSkills>  gettable();

//     @Query(value = "select ms, mt.username from MentorTable mt ")

   // @Query(value = "select ms.musername from MentorSkills ms as mt.username from MentorTable mt ON ms.mid = mt.mentorid")



}
