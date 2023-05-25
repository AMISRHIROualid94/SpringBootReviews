package com.oualid.advanced_spring_data;

import com.oualid.advanced_spring_data.models.User;
import com.oualid.advanced_spring_data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AdvancedSpringDataApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		User user1 = new User();
		User user2 = new User();
		User user3 = new User();



		user1.setFirstName("oualid");
		user1.setLastName("OUALID");
		user2.setFirstName("Nabil");
		user2.setLastName("NABIL");
		user3.setFirstName("Amine");
		user3.setLastName("AMINE");

//		userRepository.saveAll(Arrays.asList(
//
//				user1,
//				user2,
//				user3
//		));
	}
}
