package com.example.pizzeria.service;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.model.PizzaEntity;

import java.util.List;

public interface IngreEntityService {
    List<IngreEntity> get();

    IngreEntity update(IngreEntity pizzaUpdate);

    void delete(Long id);

    IngreEntity save(IngreEntity pizza);

    IngreEntity getById(Long id);
}
