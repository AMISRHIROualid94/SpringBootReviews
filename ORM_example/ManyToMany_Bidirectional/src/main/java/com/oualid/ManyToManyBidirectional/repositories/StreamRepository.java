package com.oualid.ManyToManyBidirectional.repositories;

import com.oualid.ManyToManyBidirectional.models.Stream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepository extends CrudRepository<Stream,Long> {
}
