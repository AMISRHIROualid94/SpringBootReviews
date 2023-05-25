package com.oualid.advanced_spring_data.services;

import com.oualid.advanced_spring_data.dto.UserDto;
import com.oualid.advanced_spring_data.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> ListUsers(String like);

    List<User> getUserByMulCond(UserDto user);
}
