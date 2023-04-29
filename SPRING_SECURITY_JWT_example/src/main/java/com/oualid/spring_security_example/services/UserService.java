package com.oualid.spring_security_example.services;

import com.oualid.spring_security_example.models.User;

import java.util.List;

public interface UserService {

    public String addUser(User userInfo);
    public List<User> userList();
}
