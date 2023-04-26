package com.example.pizzeria.service;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.model.PizzaEntity;

import java.util.List;

public interface OrdersEntityService {
    List<OrdersEntity> get();

    OrdersEntity update(OrdersEntity pizzaUpdate);

    void delete(Long id);

    OrdersEntity save(OrdersEntity pizza);

    OrdersEntity getById(Long id);

    OrdersEntity addPizzaToOrder(Long id, PizzaEntity pizza);
}

