package com.technologiesnew.technologies.repository;

import com.technologiesnew.technologies.entity.TechEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechRepository extends JpaRepository<TechEntity,Long> {
    List<TechEntity> findByTechname(String techname);
    List<TechEntity> findByTid(String tid);


}
