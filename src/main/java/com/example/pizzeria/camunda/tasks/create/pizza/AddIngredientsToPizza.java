package com.example.pizzeria.camunda.tasks.create.pizza;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.model.PizzaEntity;
import com.example.pizzeria.service.IngreEntityService;
import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("AddIngredientsToPizza")
public class AddIngredientsToPizza implements JavaDelegate {

    private final PizzaEntityService servicePizza;
    private final IngreEntityService serviceIngre;
    private final ModelMapper mapper;

    public AddIngredientsToPizza(PizzaEntityService servicePizza, IngreEntityService serviceIngre, ModelMapper mapper) {
        this.servicePizza = servicePizza;
        this.serviceIngre = serviceIngre;
        this.mapper = mapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        PizzaEntity pizza = mapper.map(
                servicePizza.getById(
                        (Long) delegateExecution.getVariable("pizzaId")
                ),
                PizzaEntity.class
        );
        IngreEntity ingredient = mapper.map(
                serviceIngre.getById(
                        (Long) delegateExecution.getVariable("ingredientsId")
                ),
                IngreEntity.class
        );
        servicePizza.addIngredient(pizza.getId(), ingredient);
    }
}
