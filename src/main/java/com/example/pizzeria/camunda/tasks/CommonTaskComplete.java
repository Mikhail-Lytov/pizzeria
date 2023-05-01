package com.example.pizzeria.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

@Component("CommonTaskComplete")
public class CommonTaskComplete extends FnpDelegate implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {

        mapFromTaskToProcess(delegateTask,
                "address","address",
                "ingredients", "ingredients",
                "order", "order",
                "pizzaId", "pizzaId",
                "pizza_list", "pizza_list",
                "user", "user",
                "variable", "variable");

    }
}
