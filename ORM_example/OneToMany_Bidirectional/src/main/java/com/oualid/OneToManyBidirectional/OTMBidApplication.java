package com.oualid.OneToManyBidirectional;

import com.oualid.OneToManyBidirectional.models.Cart;
import com.oualid.OneToManyBidirectional.models.Item;
import com.oualid.OneToManyBidirectional.repositories.CartRepository;
import com.oualid.OneToManyBidirectional.repositories.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class OTMBidApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OTMBidApplication.class,args);


        CartRepository cartRepository = (CartRepository) context.getBean("cartRepository");
        //ItemRepository itemRepository = (ItemRepository) context.getBean("itemRepository");

        /*List<Item> items = new ArrayList<>();
        items.add(new Item(UUID.randomUUID().toString()));
        items.add(new Item(UUID.randomUUID().toString()));
        items.add(new Item(UUID.randomUUID().toString()));
        items.add(new Item(UUID.randomUUID().toString()));*/


        Cart cart1 = new Cart("cart 1");
        List<Item> itemsForCart1 = Arrays.asList(
                new Item(UUID.randomUUID().toString()),
                new Item(UUID.randomUUID().toString()),
                new Item(UUID.randomUUID().toString()),
                new Item(UUID.randomUUID().toString()),
                new Item(UUID.randomUUID().toString())
        );

        itemsForCart1.stream().forEach(item -> {
            item.setCart(cart1);
        });

        cart1.setItems(itemsForCart1);

        cartRepository.save(cart1);

        //cartRepository.delete(cart1);

        //itemRepository.deleteById(3L);
        //itemRepository.deleteById(6L);

    }
}
