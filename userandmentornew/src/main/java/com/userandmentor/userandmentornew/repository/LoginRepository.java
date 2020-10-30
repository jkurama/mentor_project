package com.userandmentor.userandmentornew.repository;

//import com.logging.userandmentor.entity.LoginEntity;
import com.userandmentor.userandmentornew.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {

Optional<LoginEntity> deleteByUsername(String username);
   // Optional<LoginEntity> getByRegdate(String regdate);
    Optional<LoginEntity> findByUsername(String username);

}
