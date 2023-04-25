package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ingre", schema = "public", catalog = "postgres")
public class IngreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true, length = -1)
    private String name;

}
