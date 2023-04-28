package com.example.pizzeria.camunda.tasks;

import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ReturnPizza")
public class ReturnPizza implements JavaDelegate {
    private final PizzaEntityService service;
    private final ModelMapper modelMapper;

    @Autowired
    public ReturnPizza(PizzaEntityService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("pizza", service.getById((Long) delegateExecution.getVariable("pizzaId")).getName());
    }
}
