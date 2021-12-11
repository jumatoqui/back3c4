package com.usa.ciclo4.reto3.repository;

import com.usa.ciclo4.reto3.crud.OrderCrudRepository;
import com.usa.ciclo4.reto3.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll(){
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int idOrder){
        return orderCrudRepository.findById(idOrder);
    }

    public Order save(Order order){
        return orderCrudRepository.save(order);

    }

    public void update (Order order){
        orderCrudRepository.save(order);
    }

    public void delete (Integer id){
        orderCrudRepository.deleteById(id);
    }

    public List<Order> findByZone(String zone){
        return orderCrudRepository.findByZone(zone);

    }

    public List<Order> findByStatus(String status){
        return orderCrudRepository.findByStatus(status);
    }





}
