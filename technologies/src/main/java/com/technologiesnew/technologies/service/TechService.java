package com.technologiesnew.technologies.service;

import com.technologiesnew.technologies.entity.TechEntity;

import java.util.List;

public interface TechService {
    public void createTech(TechEntity techEntity);
    public List<TechEntity> getTech();
    public List<TechEntity> findByTech(String techname);
    public List<TechEntity> findByTechId(String tid);
    public TechEntity findById(long id);

}
