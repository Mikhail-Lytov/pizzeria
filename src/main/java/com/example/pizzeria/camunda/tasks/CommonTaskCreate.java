package com.example.pizzeria.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;


@Component("CommonTaskCreate")
public class CommonTaskCreate extends FnpDelegate implements TaskListener {


    @Override
    public void notify(DelegateTask delegateTask) {


        mapFromProcessToTask(delegateTask,
                "address","address",
                "ingredients", "ingredients",
                "order", "order",
                "pizzaId", "pizzaId",
                "pizzaName", "pizzaName",
                "ingredientsId", "ingredientsId",
                "pizza_list", "pizza_list",
                "user", "user",
                "variable", "variable",
                "action", "action",
                "numberOfPizzas", "numberOfPizzas",
                "idOrder","idOrder",
                "listAddress", "listAddress");
    }


}
