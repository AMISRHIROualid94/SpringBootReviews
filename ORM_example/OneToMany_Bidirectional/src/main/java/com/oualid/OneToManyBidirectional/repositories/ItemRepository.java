package com.oualid.OneToManyBidirectional.repositories;

import com.oualid.OneToManyBidirectional.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
}
