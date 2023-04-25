package com.example.pizzeria.service;

import com.example.pizzeria.model.RolesEntity;

import java.util.List;

public interface RoleEntityService {
    List<RolesEntity> get();

    RolesEntity update(RolesEntity pizzaUpdate);

    void delete(Long id);

    RolesEntity save(RolesEntity pizza);

    RolesEntity getById(Long id);
}
