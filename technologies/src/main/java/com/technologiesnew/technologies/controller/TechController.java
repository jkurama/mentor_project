package com.technologiesnew.technologies.controller;

import com.technologiesnew.technologies.entity.TechEntity;
import com.technologiesnew.technologies.service.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = {"/check"})
public class TechController {

    @Autowired
    TechService techService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TechEntity> getTechById(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        TechEntity techEntity = techService.findById(id);
        if (techEntity == null) {
            return new ResponseEntity<TechEntity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TechEntity>(HttpStatus.OK);
    }



 /*   @GetMapping(value = "/get",headers = "Accept=application.json")
    public List<TechEntity> getTech(){
        List<TechEntity> tasks = techService.getTech();
        return tasks;
   }*/

    @GetMapping(value = "/get")
    public List<TechEntity> getTech() {
        List<TechEntity> tasks = techService.getTech();
        return tasks;
    }




/*   @PostMapping(value = "/create",headers = "Accept=application.json")
    public ResponseEntity<Void> createTech(@RequestBody TechEntity techEntity, UriComponentsBuilder ucBuilder){
        System.out.println("creating Tech" +techEntity.getTechname());
        techService.createTech(techEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/{id}").buildAndExpand(techEntity.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }*/

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createTech(@RequestBody TechEntity techEntity, UriComponentsBuilder ucBuilder) {
        System.out.println("creating Tech" + techEntity.getTechname());
        techService.createTech(techEntity);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/{id}").buildAndExpand(techEntity.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/gettech/{techname}")
    public List<TechEntity> getByTech(@PathVariable String techname) {
        List<TechEntity> task = techService.findByTech(techname);
        return task;
    }


    @GetMapping(value = "/searchid/{tid}")
    public List<TechEntity> getByTechId(@PathVariable String tid) {
        List<TechEntity> task = techService.findByTechId(tid);
        return task;


    }


}
