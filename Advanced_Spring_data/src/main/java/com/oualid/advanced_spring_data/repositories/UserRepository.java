package com.oualid.advanced_spring_data.repositories;

import com.oualid.advanced_spring_data.Utils.UserSpecifications;
import com.oualid.advanced_spring_data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor {

}
