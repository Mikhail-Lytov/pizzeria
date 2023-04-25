package com.example.pizzeria.repository;

import com.example.pizzeria.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesEntityRepository extends JpaRepository<RolesEntity, Long>, JpaSpecificationExecutor<RolesEntity> {
}