package com.example.pizzeria.service;

import com.example.pizzeria.model.AddressEntity;

import java.util.List;

public interface AddressEntityService {
    List<AddressEntity> get();

    AddressEntity update(AddressEntity addressUpdate);

    void delete(Long id);

    AddressEntity save(AddressEntity address);

    AddressEntity getById(Long id);
}
