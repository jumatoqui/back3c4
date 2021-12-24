package com.usa.ciclo4.reto3.service;

import com.usa.ciclo4.reto3.model.Order;
import com.usa.ciclo4.reto3.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return (List<Order>) orderRepository.getAll();
    }


    public Order getOrder(int id) {
        return orderRepository.getOrder(id).orElse(new Order());
    }

    public List<Order> getByZone(String zone) {
        return orderRepository.findByZone(zone);
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.save(order);
        }
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> search = orderRepository.getOrder(order.getId());
            if (search.isPresent()) {
                if (order.getStatus() != null) {
                    search.get().setStatus(order.getStatus());
                }
                orderRepository.update(search.get());
                return search.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }



    public boolean delete(Integer id){
        Boolean aBoolean = orderRepository.getOrder(id).map(order -> {
            orderRepository.delete(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Reto 4: Ordenes de un asesor
    public List<Order> ordersSalesManByID(int id) {
        return orderRepository.ordersSalesManByID(id);
    }

    //Reto 4: Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }
    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id) {
        return orderRepository.ordersSalesManByState(state, id);
    }
}