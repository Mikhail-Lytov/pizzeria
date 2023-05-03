package com.example.pizzeria.camunda.tasks.pizza.order;

import com.example.pizzeria.service.OrdersEntityService;
import com.example.pizzeria.service.PizzaEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("AddPizzaToOrder")
public class AddPizzaToOrder implements JavaDelegate {

    private final ModelMapper mapper;
    private final OrdersEntityService serviceOrders;
    private final PizzaEntityService servicePizza;

    @Autowired
    public AddPizzaToOrder(ModelMapper mapper, OrdersEntityService serviceOrders, PizzaEntityService servicePizza) {
        this.mapper = mapper;
        this.serviceOrders = serviceOrders;
        this.servicePizza = servicePizza;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        try {
            serviceOrders.addPizzaToOrder(
                    (Long) delegateExecution.getVariable("idOrder"),
                    servicePizza.getById(
                            (Long) delegateExecution.getVariable("pizzaId")
                    )
            );
            delegateExecution.setVariable(
                        "numberOfPizzas",
                    (int) delegateExecution.getVariable("numberOfPizzas") + 1
            );
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " " + e.getMessage());
        }
    }
}
