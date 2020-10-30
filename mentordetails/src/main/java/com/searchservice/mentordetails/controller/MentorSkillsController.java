package com.searchservice.mentordetails.controller;

import com.searchservice.mentordetails.entity.MentorSkills;
import com.searchservice.mentordetails.entity.MentorTable;
import com.searchservice.mentordetails.service.MentorSkillsService;
import com.searchservice.mentordetails.model.*;
import com.searchservice.mentordetails.service.MentorSkillsServiceInt;
import com.searchservice.mentordetails.service.MentorTableServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import com.searchservice.mentordetails.model.MentorTable1;
@RestController
@RequestMapping(value = "/mentorskills")
public class MentorSkillsController {
    @Autowired
    MentorSkillsServiceInt mentorSkillsServiceInt;

    @Autowired
    MentorTableServiceInt mentorTableServiceInt;

    @GetMapping(value = "/get")
    public List<MentorSkills> getSkills() {
        List<MentorSkills> tasks = mentorSkillsServiceInt.getMentorSkill();

        return tasks;
    }

    /*    @GetMapping(value = "/mentorid/{mid}")
        public List<MentorSkills> getByMentorId(@PathVariable String mid){
            List<MentorSkills> tasks = mentorSkillsServiceInt.findByMentorId(mid);
            return tasks;
        }*/
    @GetMapping(value = "/getmentors/{usename}")
    public List<MentorSkills> findByMentorsId(@PathVariable("username") String username) {
        List<MentorSkills> tasks = mentorSkillsServiceInt.gettableusername();
        // MentorTable tasks1 = mentorTableServiceInt.findByUsername(username);
        //MentorSkills mentorSkills;


        return tasks;
    }

    @GetMapping(value = "/skillid/{sid}")
    public List<MentorSkills> getBySkillId(@PathVariable("sid") String sid) {
        List<MentorSkills> tasks = mentorSkillsServiceInt.findBySkillId(sid);
        return tasks;
    }

    /*   @GetMapping(value = "/skillname/{techname}")
       public List<Map<String,Object>> getBySkill(@PathVariable String techname){
           techname = TechModel.getTechname();

           String siid;
           siid = MentorSkills.getSid();
           List<Map<String,Object>> tasks = mentorSkillsServiceInt.findBySkillId(sid);
           }
       }*/

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createMentor(@RequestBody MentorSkills mentorSkills, UriComponentsBuilder ucBuilder) {
        System.out.println("new skill is" + mentorSkills.getSid());
        mentorSkillsServiceInt.createMentorSkill(mentorSkills);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/{id}").buildAndExpand(mentorSkills.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateSkill(@RequestBody MentorSkills mentorSkills) {
        System.out.println("updated");
        MentorSkills mentorSkills1 = (MentorSkills) mentorSkillsServiceInt.findById(mentorSkills.getId());
        if (mentorSkills1 == null) {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        } else {
            mentorSkillsServiceInt.update(mentorSkills, mentorSkills.getId());
            return new ResponseEntity<String>(HttpStatus.OK);

        }


    }

    @GetMapping(value = "/mentorid/{mid}")
    public List<MentorSkills> getByMentorId(@PathVariable("mid") String mid) {
        List<MentorSkills> tasks = mentorSkillsServiceInt.findByMid(mid);
        return tasks;
    }

    @GetMapping(value = "/mentor/{username}")
    public List<MentorSkills> getMentor(@PathVariable("username") String username) {


        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8848/mentortable/get/" ;

        URI uri = null;
        MentorTable1 mentorTable = new MentorTable1();


        try {
            uri = new URI(baseUrl);

        } catch (URISyntaxException e) {

            e.printStackTrace();
        }
        ResponseEntity<MentorTable1> mentor = restTemplate.getForEntity(uri + username, MentorTable1.class);

        MentorTable1 m = mentor.getBody();

        List<MentorSkills> ms =  mentorSkillsServiceInt.findByMid(m.getMentorid());



        System.out.println("from url" +m);
        NewSearch newSearch = new NewSearch();

        newSearch.setMusername(m.getUsername());
        newSearch.setMid(m.getMentorid());
       // newSearch.setFacilities(ms.getFacilities());
 //       newSearch.setSid(ms.getSid());
      //  newSearch.setNumberoftrainings(ms.getNumberoftrainings());


        return ms;
      //  return  new ResponseEntity<NewSearch>(newSearch,HttpStatus.OK);
       // return null;
    }

    @GetMapping(value = "/skill/{techname}")
    public List<MentorSkills> getSkills(@PathVariable("techname") String techname) {


        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8858/check/gettech/" ;

        URI uri = null;
       TechModel techModel = new TechModel();
        ArrayList<MentorSearch> fin = new ArrayList<MentorSearch>();

        try {
            uri = new URI(baseUrl);

        } catch (URISyntaxException e) {

            e.printStackTrace();
        }
        ResponseEntity<TechModel[]> tm = restTemplate.getForEntity(uri + techname, TechModel[].class);

        TechModel[] techModel1 = tm.getBody();

        int length= techModel1.length;

       for(int j=0;j<length;j++){
           techModel = techModel1[j];
           System.out.println(techModel);
       }








        List<MentorSkills> ms =  mentorSkillsServiceInt.findBySkillId(techModel.getTid());



        System.out.println("abc: "+length);




        return ms ;

        //List<MentorTable> mentorTables = mentorTableServiceInt.findByMid()


        //  return  new ResponseEntity<NewSearch>(newSearch,HttpStatus.OK);
        // return null;
    }




}