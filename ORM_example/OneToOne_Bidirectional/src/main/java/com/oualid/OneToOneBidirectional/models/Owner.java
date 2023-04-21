package com.oualid.OneToOneBidirectional.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "OWNERS_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;


    public Owner(String name,Car car){
        this.name =name;
        this.car = car;
    }
}
