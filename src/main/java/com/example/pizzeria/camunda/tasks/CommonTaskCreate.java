package com.example.pizzeria.camunda.tasks;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;


@Component("CommonTaskCreate")
public class CommonTaskCreate extends FnpDelegate implements TaskListener {


    @Override
    public void notify(DelegateTask delegateTask) {


        mapFromProcessToTask(delegateTask,
                "pizzaId", "pizzaId",
                "pizza","pizza",
                "address","address",
                "ingredients", "ingredients");
    }


}
