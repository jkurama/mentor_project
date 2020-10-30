package com.technologiesnew.technologies.service;

import com.technologiesnew.technologies.entity.TechEntity;
import com.technologiesnew.technologies.repository.TechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechServiceImp implements TechService{

    @Autowired
    TechRepository techRepository;


    public void createTech(TechEntity techEntity) {
        techRepository.save(techEntity);

    }


    public List<TechEntity> getTech() {


        return techRepository.findAll();
    }


    public List<TechEntity> findByTech(String techname) {
        return techRepository.findByTechname(techname);
    }


    public List<TechEntity> findByTechId(String tid) {
        return techRepository.findByTid(tid);
    }


    public TechEntity findById(long id) {
        return techRepository.findById(id).get();
    }
}
