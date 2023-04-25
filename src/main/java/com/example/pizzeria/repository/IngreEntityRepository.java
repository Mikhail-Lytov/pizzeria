package com.example.pizzeria.repository;

import com.example.pizzeria.model.IngreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IngreEntityRepository extends JpaRepository<IngreEntity, Long>, JpaSpecificationExecutor<IngreEntity> {
}