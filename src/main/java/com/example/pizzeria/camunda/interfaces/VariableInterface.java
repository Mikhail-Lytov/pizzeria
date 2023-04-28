package com.example.pizzeria.camunda.interfaces;

public interface VariableInterface {
    Object get(String name);

    void set(String name, Object value);
}
