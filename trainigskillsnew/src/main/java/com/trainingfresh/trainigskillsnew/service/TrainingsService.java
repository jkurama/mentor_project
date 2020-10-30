package com.trainingfresh.trainigskillsnew.service;

import com.trainingfresh.trainigskillsnew.entity.TrainingsEntity;
import com.trainingfresh.trainigskillsnew.repository.TrainingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingsService implements TrainingsServiceInt {

    @Autowired
    TrainingsRepository trainingsRepository;


    public void createTrainingTable(TrainingsEntity trainingsEntity) {
        trainingsRepository.save(trainingsEntity);
    }

    public List<TrainingsEntity> getDetails() {
        return trainingsRepository.findAll();
    }

    public List<TrainingsEntity> findByUserId(String userid)
    {
        return trainingsRepository.findByUserId(userid) ;
    }

    public List<TrainingsEntity> findByMentorId(String mid) {

        return trainingsRepository.findByMid(mid) ;
    }

    public List<TrainingsEntity> findByTrainingStatus(String status) {
        return trainingsRepository.findByStatus(status);
    }

    public List<TrainingsEntity> findBySlot(String slot) {
        return trainingsRepository.findBySlot(slot);
    }
}
