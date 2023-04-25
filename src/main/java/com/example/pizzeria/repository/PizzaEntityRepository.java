package com.example.pizzeria.repository;

import com.example.pizzeria.model.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaEntityRepository extends JpaRepository<PizzaEntity, Long>, JpaSpecificationExecutor<PizzaEntity> {
}