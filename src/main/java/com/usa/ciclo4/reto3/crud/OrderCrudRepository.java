package com.usa.ciclo4.reto3.crud;

import com.usa.ciclo4.reto3.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderCrudRepository extends MongoRepository <Order, Integer>{

    //retorna las ordenes de pedido que coincidan con la zona recibida como parámetro
    @Query("{'salesMan.zone':?0}")
    List<Order>findByZone(final String zone);

    //Retorne las ordenes por status
    @Query("{status:?0}")
    List<Order>findByStatus(final String status);
}
