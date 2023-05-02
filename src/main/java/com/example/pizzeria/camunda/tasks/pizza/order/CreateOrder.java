package com.example.pizzeria.camunda.tasks.pizza.order;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.model.UserEntity;
import com.example.pizzeria.service.OrdersEntityService;
import com.example.pizzeria.service.UserEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CreateOrder")
public class CreateOrder implements JavaDelegate {
    private final OrdersEntityService serviceOrders;
    private final UserEntityService serviceUser;

    @Autowired
    public CreateOrder(OrdersEntityService serviceOrders, UserEntityService serviceUser) {
        this.serviceOrders = serviceOrders;
        this.serviceUser = serviceUser;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        UserEntity user = serviceUser.getById(
                (Long) delegateExecution.getVariable("user")
        );
        OrdersEntity order = serviceOrders.save(new OrdersEntity());
        user.getOrders().add(order);
        serviceUser.update(user);

        delegateExecution.setVariable(
                "idOrder",
                order.getId());

        delegateExecution.setVariable(
                "user",
                user.getId()
        );

        delegateExecution.setVariable(
                "numberOfPizzas", 0
        );

    }
}
