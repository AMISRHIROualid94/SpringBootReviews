package com.oualid.OneToManyUnidirectional.repositories;

import com.oualid.OneToManyUnidirectional.models.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<University,Long> {
}
