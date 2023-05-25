package com.oualid.advanced_spring_data.controller;

import com.oualid.advanced_spring_data.dto.UserDto;
import com.oualid.advanced_spring_data.models.User;
import com.oualid.advanced_spring_data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users",produces = "application/json")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/allUsers")
    public List<User> userList(@RequestParam String like){
        return userService.ListUsers(like);
    }


    @PostMapping(value = "/userByFN")
    public List<User> getUserByFN(@RequestBody UserDto user){
        return userService.getUserByMulCond(user);
    }
}
