package com.userandmentor.userandmentornew.service;

//import com.logging.userandmentor.entity.LoginEntity;
//import com.logging.userandmentor.exception.RecordNotFound;
//import com.logging.userandmentor.repository.LoginRepository;
import com.userandmentor.userandmentornew.entity.LoginEntity;
import com.userandmentor.userandmentornew.exception.RecordNotFound;
import com.userandmentor.userandmentornew.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import java.awt.print.Pageable;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public List<LoginEntity> getAllDetails(Integer pageNo, Integer pageSize, String sortBy){
       Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<LoginEntity> pageResult = loginRepository.findAll(paging);

        if(pageResult.hasContent()){
            return pageResult.getContent();
        }else{
            return new ArrayList<LoginEntity>();
        }

    }
  /*  public List<LoginEntity> getAllDetailsbyDate(Integer pageNo,Integer pageSize,String sortBy){
        Pageable paging = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));

        Page<LoginEntity> pageResult = loginRepository.findAll(paging);

        if(pageResult.hasContent()){
            return pageResult.getContent();
        }else{
            return new ArrayList<LoginEntity>();
        }

    }*/

    public LoginEntity getUsersById(Long id) throws RecordNotFound
    {
        Optional<LoginEntity> users = loginRepository.findById(id);
        if(users.isPresent()){
            return users.get();
        }else {
            throw new RecordNotFound("No Employee records");

        }
    }

    public LoginEntity createorUpdateUsers(LoginEntity loginEntity) throws RecordNotFound
    {
        System.out.println("the user is" +loginEntity.getMode());
        Optional<LoginEntity> users = loginRepository.findById(loginEntity.getId());

        if(users.isPresent()){
            LoginEntity newEntity = users.get();
            newEntity.setActive(loginEntity.getActive());
            newEntity.setContact(loginEntity.getContact());
            newEntity.setFirstname(loginEntity.getFirstname());
            newEntity.setLastname(loginEntity.getLastname());
            newEntity.setUsername(loginEntity.getUsername());
            newEntity.setMode(loginEntity.getMode());;
            newEntity.setRegdate(loginEntity.getRegdate());
            newEntity.setRegcode(loginEntity.getRegcode());
            newEntity.setPassword(loginEntity.getPassword());

            return newEntity;

        }else {
            loginEntity = loginRepository.save(loginEntity);

            return loginEntity;
        }
    }

    public Optional<LoginEntity> deleteByUsername(String username) throws RecordNotFound{
        Optional<LoginEntity> users = loginRepository.findByUsername(username);

        if(users.isPresent())
        {
            return loginRepository.deleteByUsername(username);

        }else {
            throw new RecordNotFound("No user like that");
        }
    }

    public LoginEntity findByUsername(String username) throws RecordNotFound{
        Optional<LoginEntity> user = loginRepository.findByUsername(username);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new RecordNotFound("Incorrect Username");
        }



    }


}
