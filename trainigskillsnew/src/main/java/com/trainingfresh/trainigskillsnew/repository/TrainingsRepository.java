package com.trainingfresh.trainigskillsnew.repository;

import com.trainingfresh.trainigskillsnew.entity.TrainingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingsRepository extends JpaRepository<TrainingsEntity , Long> {
    List<TrainingsEntity> findByMid(String mid);
    List<TrainingsEntity> findBySid(String sid);
    List<TrainingsEntity> findByUserId(String userid);
    List<TrainingsEntity> findBySlot(String slot);

    //    @Query(value = "select ts from TrainingsEntity ts where ts.status =? Approved ")
    List<TrainingsEntity> findByStatus(String status);


}
