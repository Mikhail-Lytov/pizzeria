package com.example.pizzeria.camunda.tasks;

import com.example.pizzeria.service.AddressEntityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ReturnListAddress")
public class ReturnListAddress implements JavaDelegate {

    private final ModelMapper mapper;

    private final AddressEntityService serviceAddress;

    @Autowired
    public ReturnListAddress(ModelMapper mapper, AddressEntityService serviceAddress) {
        this.mapper = mapper;
        this.serviceAddress = serviceAddress;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        //delegateExecution.setVariable("listAddress", delegateExecution.get);
    }
}
