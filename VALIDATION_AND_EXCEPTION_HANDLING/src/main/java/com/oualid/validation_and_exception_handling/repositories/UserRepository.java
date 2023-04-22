package com.oualid.validation_and_exception_handling.repositories;

import com.oualid.validation_and_exception_handling.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
