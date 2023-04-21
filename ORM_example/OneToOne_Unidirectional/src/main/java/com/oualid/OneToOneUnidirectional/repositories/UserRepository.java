package com.oualid.OneToOneUnidirectional.repositories;

import com.oualid.OneToOneUnidirectional.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
