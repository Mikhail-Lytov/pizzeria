package com.example.pizzeria.camunda.interfaces;

@FunctionalInterface
public interface MappingInterface {
    void map(VariableInterface taskVars, VariableInterface processVars);
}
