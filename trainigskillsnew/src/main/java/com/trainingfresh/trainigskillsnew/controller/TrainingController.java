package com.trainingfresh.trainigskillsnew.controller;


import com.trainingfresh.trainigskillsnew.entity.TrainingsEntity;
import com.trainingfresh.trainigskillsnew.service.TrainingsServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
//import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping(value = "/trainingdetails")
public class TrainingController {

    @Autowired
    TrainingsServiceInt trainingsServiceInt;



    //@Autowired
    //private RestTemplate restTemplate;

   @GetMapping(value = "/get")
    public List<TrainingsEntity> getTrainings(){
        List<TrainingsEntity> tasks = trainingsServiceInt.getDetails();
        return tasks;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createTraining(@RequestBody TrainingsEntity trainingsEntity , UriComponentsBuilder uriComponentsBuilder){
        System.out.println("new training is" + trainingsEntity.getMid());
        trainingsServiceInt.createTrainingTable(trainingsEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/create/{id}").buildAndExpand(trainingsEntity.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value = "/mentorid/{mid}")
    public List<TrainingsEntity> getByMentorId(@PathVariable("mid") String mid){
        List<TrainingsEntity> task = trainingsServiceInt.findByMentorId(mid);
        return task;
    }

    @GetMapping(value = "/status/{status}")
    public List<TrainingsEntity> getByStatus(@PathVariable("status") String status){
        List<TrainingsEntity> task = trainingsServiceInt.findByTrainingStatus(status);
        return task;
    }

    @GetMapping(value = "/userid/{userid}")
    public List<TrainingsEntity> getByUserId(@PathVariable("userid") String userid){
        List<TrainingsEntity> task = trainingsServiceInt.findByUserId(userid);
        return task;
    }

    @GetMapping(value = "/slot/{slot}")
    public List<TrainingsEntity> getBySlot(@PathVariable("slot") String slot){
        List<TrainingsEntity> task = trainingsServiceInt.findBySlot(slot);
        return task;
    }






}
