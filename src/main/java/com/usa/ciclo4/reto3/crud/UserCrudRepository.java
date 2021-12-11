package com.usa.ciclo4.reto3.crud;

import com.usa.ciclo4.reto3.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;


public interface UserCrudRepository extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
    public List<User> findByNameOrEmail(String name, String email);
}
