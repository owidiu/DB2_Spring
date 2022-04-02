package com.example.spring2.services;
import com.example.spring2.model.Order;
import com.example.spring2.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getById(Integer id) {
        return orderRepository.findById(id).get();
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(orders::add);
        return orders;
    }

    public Order insert(Order order) {
        return orderRepository.save(order);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }

    public void delete(Order order) {
        orderRepository.delete(order);
    }


    public List<Order> getOrdersByCustomerId(Integer customerId) {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().iterator().forEachRemaining(orders::add);
        List<Order> filteredOrders = new ArrayList<>();

        for (Order order : orders) {
            if ((this.getCustomerId()).equals(customerId)) {
                filteredOrders.add(order);
            }
        }
        return filteredOrders;
    }


}
