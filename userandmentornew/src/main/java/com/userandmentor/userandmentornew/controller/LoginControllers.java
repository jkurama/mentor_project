package com.userandmentor.userandmentornew.controller;

//import com.logging.userandmentor.entity.LoginEntity;
//import com.logging.userandmentor.exception.RecordNotFound;
//import com.logging.userandmentor.service.LoginService;
import com.userandmentor.userandmentornew.entity.LoginEntity;
import com.userandmentor.userandmentornew.exception.RecordNotFound;
import com.userandmentor.userandmentornew.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class LoginControllers {

@Autowired
LoginService loginService;



    @GetMapping("/getall")
    public ResponseEntity<List<LoginEntity>> getAllDetails(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<LoginEntity> list = loginService.getAllDetails(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<LoginEntity>>(list,new HttpHeaders() , HttpStatus.OK);

    }

/*    @GetMapping
    public ResponseEntity<List<LoginEntity>> getAllDetailsByDate(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy){
        List<LoginEntity> list = loginService.getAllDetailsbyDate(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<LoginEntity>>(list,new HttpHeaders() ,HttpStatus.OK);
    }*/




    @PostMapping("/create")
    public ResponseEntity<LoginEntity> createOrUpdateuser(@RequestBody LoginEntity loginEntity)
        throws RecordNotFound{
        System.out.println("customer is"+loginEntity.getMode());
        LoginEntity updated = loginService.createorUpdateUsers(loginEntity);
        return new ResponseEntity<LoginEntity>(updated,new HttpHeaders() ,HttpStatus.OK);
    }

    @DeleteMapping("delete/{username}")
    public HttpStatus deleteUser(@PathVariable("username") String username)
                                throws RecordNotFound{
        loginService.deleteByUsername(username);
        return HttpStatus.FORBIDDEN;
    }

    @GetMapping("/byusername/{username}")
    public ResponseEntity<LoginEntity> findByUsername(@PathVariable("username") String username) throws RecordNotFound {

        LoginEntity loginEntity = loginService.findByUsername(username);
        return new ResponseEntity<LoginEntity>(loginEntity,new HttpHeaders(),HttpStatus.OK);

    }
}
