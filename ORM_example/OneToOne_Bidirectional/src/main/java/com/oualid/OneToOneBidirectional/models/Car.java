package com.oualid.OneToOneBidirectional.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CARS_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;
    private String model;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private Owner owner;

    public Car(String model){
        this.model = model;
    }
}
