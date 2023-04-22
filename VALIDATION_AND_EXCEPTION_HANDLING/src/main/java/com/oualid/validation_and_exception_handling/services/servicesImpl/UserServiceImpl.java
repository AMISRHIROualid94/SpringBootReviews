package com.oualid.validation_and_exception_handling.services.servicesImpl;

import com.oualid.validation_and_exception_handling.dto.UserRequest;
import com.oualid.validation_and_exception_handling.models.User;
import com.oualid.validation_and_exception_handling.models.exceptions.UserNameBiginWithONotFoundException;
import com.oualid.validation_and_exception_handling.models.exceptions.UserNotFoundException;
import com.oualid.validation_and_exception_handling.models.exceptions.UsersFoundedNumberLessThanFiveException;
import com.oualid.validation_and_exception_handling.repositories.UserRepository;
import com.oualid.validation_and_exception_handling.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;


    @Override
    public User saveUser(UserRequest userRequest) {
        char c = userRequest.getName().charAt(0);
        if (Character.isUpperCase(c)){
            User user = new User(userRequest.getName(), userRequest.getEmail(),
                    userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
            return userRepository.save(user);
        }else {
            throw new UserNameBiginWithONotFoundException("User Name Must be Uppercase!");
        }

    }

    @Override
    public List<User> getALlUsers() {
        int usersNumber = (int) userRepository.findAll().stream().count();
        if (usersNumber >= 5) {
            return userRepository.findAll();
        }else {
            throw new UsersFoundedNumberLessThanFiveException("Users founded are less than five!");
        }
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            return optionalUser.get();
        }else {
            throw new UserNotFoundException("User not found");
        }
    }
}
