package com.example.pizzeria.repository;

import com.example.pizzeria.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersEntityRepository extends JpaRepository<OrdersEntity, Long>, JpaSpecificationExecutor<OrdersEntity> {
}