package com.oualid.validation_and_exception_handling.services;

import com.oualid.validation_and_exception_handling.dto.UserRequest;
import com.oualid.validation_and_exception_handling.models.User;

import java.util.List;

public interface UserService {
    User saveUser(UserRequest userRequest);
    List<User> getALlUsers();
    User getUser(Long id);
}
