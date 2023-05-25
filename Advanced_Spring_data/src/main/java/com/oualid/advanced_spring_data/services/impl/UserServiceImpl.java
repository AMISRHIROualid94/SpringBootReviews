package com.oualid.advanced_spring_data.services.impl;

import com.oualid.advanced_spring_data.Utils.UserSpecifications;
import com.oualid.advanced_spring_data.dto.UserDto;
import com.oualid.advanced_spring_data.models.User;
import com.oualid.advanced_spring_data.repositories.UserRepository;
import com.oualid.advanced_spring_data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> ListUsers(String like) {
        return userRepository.findAll(UserSpecifications.UserNameLike(like));
    }

    @Override
    public List<User> getUserByMulCond(UserDto user) {
        return userRepository.findAll(UserSpecifications.UserByMulCond(user));
    }
}
