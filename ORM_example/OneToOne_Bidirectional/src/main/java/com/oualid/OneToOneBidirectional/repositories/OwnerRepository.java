package com.oualid.OneToOneBidirectional.repositories;

import com.oualid.OneToOneBidirectional.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {

    void deleteOwnerById(Long id);
}
