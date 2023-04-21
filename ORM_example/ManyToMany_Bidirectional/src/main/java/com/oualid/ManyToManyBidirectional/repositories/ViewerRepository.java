package com.oualid.ManyToManyBidirectional.repositories;

import com.oualid.ManyToManyBidirectional.models.Viewer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerRepository extends CrudRepository<Viewer,Long> {
}
