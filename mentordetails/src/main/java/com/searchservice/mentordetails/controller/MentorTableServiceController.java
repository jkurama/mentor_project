package com.searchservice.mentordetails.controller;

import com.searchservice.mentordetails.entity.MentorTable;
import com.searchservice.mentordetails.service.MentorTableServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/mentortable")
public class MentorTableServiceController {

    @Autowired
    MentorTableServiceInt mentorTableServiceInt;


    @GetMapping(value = "/getTables")
    public List<MentorTable> getTable() {
        List<MentorTable> tasks = mentorTableServiceInt.getMentorTable();
        return tasks;
    }

    @GetMapping(value = "/get/{username}")
    public MentorTable getMentor(@PathVariable("username") String username) {
        MentorTable mentorTable = mentorTableServiceInt.findByUsername(username);
        return mentorTable;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createMentor(@RequestBody MentorTable mentorTable, UriComponentsBuilder ucBuilder) {
        System.out.println("new mentor is" + mentorTable.getUsername());
        mentorTableServiceInt.createMentorTable(mentorTable);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/{id}").buildAndExpand(mentorTable.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateSkill(@RequestBody MentorTable mentorTable) {
        System.out.println("updated");
        MentorTable mentorTable1 = mentorTableServiceInt.findById(mentorTable.getId());
        if (mentorTable1 == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            mentorTableServiceInt.update(mentorTable, mentorTable.getId());
            return new ResponseEntity<String>(HttpStatus.OK);

        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MentorTable> getTechById(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        MentorTable mentorTable = mentorTableServiceInt.findById(id);
        if (mentorTable == null) {
            return new ResponseEntity<MentorTable>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MentorTable>(HttpStatus.OK);
    }

}