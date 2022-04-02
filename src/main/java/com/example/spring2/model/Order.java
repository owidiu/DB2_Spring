package com.example.spring2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "CustomerOrder")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Integer order_id;
    private String name;
    @ManyToOne
    Customer customer;
    @ManyToOne
    Product product;
    private Integer quantity;
    private Double price;
    private Double total;

    public Order(String name) {
        this.name = name;
    }

    //public Integer getCustomerId() {
    //    return customerService.getById(id);
    //}
}
