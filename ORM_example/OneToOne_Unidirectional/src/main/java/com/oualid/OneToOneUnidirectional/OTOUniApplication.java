package com.oualid.OneToOneUnidirectional;

import com.oualid.OneToOneUnidirectional.models.Address;
import com.oualid.OneToOneUnidirectional.models.User;
import com.oualid.OneToOneUnidirectional.repositories.AddressRepository;
import com.oualid.OneToOneUnidirectional.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OTOUniApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OTOUniApplication.class,args);

        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
        AddressRepository addressRepository = (AddressRepository) context.getBean("addressRepository");

        Address address1 = new Address("Address 1");
        Address address2 = new Address("Address 2");

        addressRepository.save(address1);
        addressRepository.save(address2);

        User user1 = new User("user 1",address1);
        User user2 = new User("user 2",address2);

        userRepository.save(user1);
        userRepository.save(user2);


        userRepository.delete(user1);
        addressRepository.delete(address1);
    }
}
