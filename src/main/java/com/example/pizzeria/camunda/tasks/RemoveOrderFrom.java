package com.example.pizzeria.camunda.tasks;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.service.OrdersEntityService;
import com.example.pizzeria.service.UserEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component("RemoveOrderFrom")
public class RemoveOrderFrom implements JavaDelegate {
    private final OrdersEntityService serviceOrder;
    private final UserEntityService serviceUser;
    private final ModelMapper mapper;

    public RemoveOrderFrom(OrdersEntityService serviceOrder, UserEntityService serviceUser, ModelMapper mapper) {
        this.serviceOrder = serviceOrder;
        this.serviceUser = serviceUser;
        this.mapper = mapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        OrdersEntity order = mapper.map(
                serviceOrder.getById(
                        (Long) delegateExecution.getVariable("idOrder")
                        ),
                OrdersEntity.class
        );
    }
}
