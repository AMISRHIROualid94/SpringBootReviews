package com.oualid.spring_security_example.controller;

import com.oualid.spring_security_example.config.UserInfosDetailsService;
import com.oualid.spring_security_example.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserInfosDetailsService service;

    @PostMapping("/new")
    public String addNewUser(@RequestBody @Valid User userInfo){
        return service.addUser(userInfo);
    }

}
