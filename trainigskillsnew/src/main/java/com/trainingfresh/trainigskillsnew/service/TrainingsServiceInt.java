package com.trainingfresh.trainigskillsnew.service;

import com.trainingfresh.trainigskillsnew.entity.TrainingsEntity;

import java.util.List;

public interface TrainingsServiceInt {

    public void createTrainingTable(TrainingsEntity trainingsEntity);
    public List<TrainingsEntity> getDetails();
    public List<TrainingsEntity> findByUserId(String userid);
    public List<TrainingsEntity> findByMentorId(String mid);
    public List<TrainingsEntity> findByTrainingStatus(String status);
    public List<TrainingsEntity> findBySlot(String slot);
}
