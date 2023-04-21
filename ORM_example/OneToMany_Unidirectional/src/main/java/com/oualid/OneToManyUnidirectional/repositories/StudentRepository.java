package com.oualid.OneToManyUnidirectional.repositories;

import com.oualid.OneToManyUnidirectional.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

}
