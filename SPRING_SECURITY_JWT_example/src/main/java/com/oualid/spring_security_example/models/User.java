package com.oualid.spring_security_example.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="USER_TAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Name must not be null")
    private String name;
    @NotNull(message = "Name must not be null")
    @Email(message = "invalid email address")
    private String email;
    @NotBlank
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "invalid password - 8 letters ")
    private String password;
    @NotBlank
    private String roles;

    public User(String name,String email,String password,String roles){
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;

    }
}
