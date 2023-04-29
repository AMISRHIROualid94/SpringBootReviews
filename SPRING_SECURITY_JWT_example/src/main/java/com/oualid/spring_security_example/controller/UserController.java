package com.oualid.spring_security_example.controller;

import com.oualid.spring_security_example.config.UserInfosDetailsService;
import com.oualid.spring_security_example.dto.AuthRequest;
import com.oualid.spring_security_example.models.User;
import com.oualid.spring_security_example.services.JWTService;
import com.oualid.spring_security_example.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/new")
    public String addNewUser(@RequestBody @Valid User userInfo){
        return service.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticationAndGetToken(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(request.getUsername());
        }else {
            throw new UsernameNotFoundException("Invalid username request!");
        }

    }

    @GetMapping("/all")
    public List<User> userList(){
        return this.service.userList();
    }

}
