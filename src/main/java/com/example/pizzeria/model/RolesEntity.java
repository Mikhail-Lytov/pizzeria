package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "roles", schema = "public", catalog = "postgres")
public class RolesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;

}
