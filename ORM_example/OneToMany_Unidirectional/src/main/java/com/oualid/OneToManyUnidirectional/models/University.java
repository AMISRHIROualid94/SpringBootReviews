package com.oualid.OneToManyUnidirectional.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UNIVERSITIES_TAB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "university_id")
    private List<Student> students = new ArrayList<>();
    public University(String name,List<Student> students){
        this.name = name;
        this.students = students;
    }
}
