package com.example.pizzeria.camunda.tasks.pizza.order;

import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("ReturnPizzaMenu")
public class ReturnPizzaMenu implements JavaDelegate {
    private final PizzaEntityService service;
    private final ModelMapper modelMapper;

    @Autowired
    public ReturnPizzaMenu(PizzaEntityService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //Map<String, Object> variables = delegateExecution.getVariables();
        //System.out.println(variables);
        delegateExecution.setVariable("pizza_list", service.get().toString());
        //delegateExecution.setVariable("pizza", service.getById((Long) delegateExecution.getVariable("pizzaId")).getName());
    }
}
