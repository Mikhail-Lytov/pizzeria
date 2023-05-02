package com.example.pizzeria.camunda.tasks.pizza.order;

import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ShowPizzaIngredients")
public class ShowPizzaIngredients implements JavaDelegate {

    private final PizzaEntityService service;
    private final ModelMapper mapper;

    @Autowired
    public ShowPizzaIngredients(PizzaEntityService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("ingredients", service.getIngredients((Long) delegateExecution.getVariable("pizzaId")).toString());

    }
}
