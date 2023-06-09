package com.example.pizzeria.service;

import com.example.pizzeria.model.AddressEntity;
import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.model.UserEntity;

import java.util.List;

public interface UserEntityService {
    List<UserEntity> get();

    UserEntity update(UserEntity pizzaUpdate);

    void delete(Long id);

    UserEntity save(UserEntity pizza);

    UserEntity getById(Long id);

    UserEntity addOrder(Long id, OrdersEntity order);

    UserEntity deleteOrderToUser(Long id, OrdersEntity order);

    UserEntity addAdress(Long id, AddressEntity address);
}
