package com.usa.ciclo4.reto3;

import com.usa.ciclo4.reto3.crud.CleaningProductCrudRepository;
import com.usa.ciclo4.reto3.crud.OrderCrudRepository;
import com.usa.ciclo4.reto3.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto3Application implements CommandLineRunner{

    @Autowired
    private CleaningProductCrudRepository cleaningProductRepository;

    @Autowired
    private UserCrudRepository userRepository;

    @Autowired
    private OrderCrudRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        cleaningProductRepository.deleteAll();
        orderRepository.deleteAll();
    }

}
