package com.example.pizzeria.camunda.tasks.create.pizza;

import com.example.pizzeria.model.PizzaEntity;
import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CreatePizza")
public class CreatePizza implements JavaDelegate {

    private final ModelMapper mapper;
    private final PizzaEntityService servicePizza;

    @Autowired
    public CreatePizza(ModelMapper mapper, PizzaEntityService servicePizza) {
        this.mapper = mapper;
        this.servicePizza = servicePizza;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PizzaEntity pizza = new PizzaEntity();
        pizza.setName(delegateExecution.getVariable("pizzaName").toString());

        pizza = mapper.map(servicePizza.save(pizza), PizzaEntity.class);

        delegateExecution.setVariable("pizzaId", pizza.getId());
    }
}
