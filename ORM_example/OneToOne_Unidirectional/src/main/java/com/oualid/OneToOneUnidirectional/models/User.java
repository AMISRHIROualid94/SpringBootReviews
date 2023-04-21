package com.oualid.OneToOneUnidirectional.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USERS_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    public User(String name,Address address){
        this.name = name;
        this.address = address;
    }
}
