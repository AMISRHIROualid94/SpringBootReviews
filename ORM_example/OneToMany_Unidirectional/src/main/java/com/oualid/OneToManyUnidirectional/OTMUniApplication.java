package com.oualid.OneToManyUnidirectional;

import com.oualid.OneToManyUnidirectional.models.Student;
import com.oualid.OneToManyUnidirectional.models.University;
import com.oualid.OneToManyUnidirectional.repositories.StudentRepository;
import com.oualid.OneToManyUnidirectional.repositories.UniversityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OTMUniApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OTMUniApplication.class,args);

        StudentRepository studentRepository = (StudentRepository) context.getBean("studentRepository");
        UniversityRepository universityRepository = (UniversityRepository) context.getBean("universityRepository");

        List<Student> studentsList1 = Arrays.asList(
                new Student("Student 1"),
                new Student("Student 2"),
                new Student("Student 3"),
                new Student("Student 4")
        );

        University university1 = new University("University 1",studentsList1);

        universityRepository.save(university1);


        //studentRepository.deleteById(1L);
        //universityRepository.delete(university1);
    }
}
