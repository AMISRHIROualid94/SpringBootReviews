package com.oualid.validation_and_exception_handling;

import com.oualid.validation_and_exception_handling.dto.UserRequest;
import com.oualid.validation_and_exception_handling.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ValidationAndExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationAndExceptionHandlingApplication.class, args);

        /*UserService userService = (UserService) context.getBean("userServiceImpl");

        UserRequest userRequest = UserRequest.build(
                "name",
                "name@gmail.com",
                "0660660600",
                "gender",
                20,
                "morocco");

        userService.saveUser(userRequest);*/
    }

}
