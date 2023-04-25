package com.example.pizzeria.service;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.model.PizzaEntity;

import java.util.List;


public interface PizzaEntityService {

    List<PizzaEntity> get();

    PizzaEntity update(PizzaEntity pizzaUpdate);

    void delete(Long id);

     PizzaEntity save(PizzaEntity pizza);

     PizzaEntity getById(Long id);

     List<IngreEntity> getIngredients(PizzaEntity pizza);

     PizzaEntity addIngredient(Long id, IngreEntity ingredient);
}
