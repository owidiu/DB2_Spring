package com.example.spring2.dto;

import com.example.spring2.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private String name;
    private List<Order> orders;
}
