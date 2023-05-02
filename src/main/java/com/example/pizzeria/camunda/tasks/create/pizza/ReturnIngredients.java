package com.example.pizzeria.camunda.tasks.create.pizza;

import com.example.pizzeria.service.IngreEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ReturnIngredients")
public class ReturnIngredients implements JavaDelegate {
    private final IngreEntityService serviceIngre;
    private final ModelMapper mapper;

    @Autowired
    public ReturnIngredients(IngreEntityService serviceIngre, ModelMapper mapper) {
        this.serviceIngre = serviceIngre;
        this.mapper = mapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("ingredients", serviceIngre.get().toString());
        System.out.println(serviceIngre.get());
    }
}
