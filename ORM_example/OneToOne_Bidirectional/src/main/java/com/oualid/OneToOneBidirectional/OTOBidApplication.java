package com.oualid.OneToOneBidirectional;

import com.oualid.OneToOneBidirectional.models.Car;
import com.oualid.OneToOneBidirectional.models.Owner;
import com.oualid.OneToOneBidirectional.repositories.CarRepository;
import com.oualid.OneToOneBidirectional.repositories.OwnerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OTOBidApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(OTOBidApplication.class, args);

        CarRepository carRepository = (CarRepository) context.getBean("carRepository");
        OwnerRepository ownerRepository = (OwnerRepository) context.getBean("ownerRepository");

        Car car1 = new Car("model1");
        Car car2 = new Car("model2");
        carRepository.save(car1);
        carRepository.save(car2);

        Owner owner1 = new Owner("owner1",car1);
        Owner owner2 = new Owner("owner2",car2);
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);

        //owner1.setCar(null);
        //ownerRepository.save(owner1);
        //ownerRepository.delete(owner1);
        //carRepository.delete(car1);
    }

}
