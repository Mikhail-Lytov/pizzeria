package com.example.pizzeria.camunda.tasks.create.pizza;

import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("RemovePizza")
public class RemovePizza implements JavaDelegate {

    private final PizzaEntityService servicePizza;

    @Autowired
    public RemovePizza(PizzaEntityService servicePizza) {
        this.servicePizza = servicePizza;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        try {
            servicePizza.delete(
                    (Long) delegateExecution.getVariable("PizzaId")
            );
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " " + e.getMessage());
        }
    }
}
