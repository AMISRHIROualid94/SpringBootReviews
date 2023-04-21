package com.oualid.OneToManyBidirectional.repositories;

import com.oualid.OneToManyBidirectional.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
}
