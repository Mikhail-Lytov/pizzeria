package com.example.pizzeria.repository;

import com.example.pizzeria.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, Long>, JpaSpecificationExecutor<AddressEntity> {
}