package com.example.spring2.controllers;


import com.example.spring2.dto.OrderDTO;
import com.example.spring2.model.Order;

import com.example.spring2.services.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        orderService.insert(order);
        return order;
    }

    @PostMapping("/orders-dto")
    public Order createOrderDTO(@RequestBody OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getName());
        return orderService.insert(order);
    }


    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@RequestBody Order order) {
        orderService.delete(order);
    }


    @PostMapping("/orders/update")
    public Order updateOrder(@RequestBody Order order) {
        orderService.update(order);
        return order;
    }

    @GetMapping("/orders/{id}")
    public List<Order> getOrdersByCustomerId(@PathVariable Integer id){
        return orderService.getOrdersByCustomerId(id);
    }

}
