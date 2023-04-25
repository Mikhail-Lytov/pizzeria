package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "pizza", schema = "public", catalog = "postgres")
public class PizzaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pizza", nullable = false)
    private long idPizza;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "pizza_about",
            joinColumns = @JoinColumn(name = "id_pizza"),
            inverseJoinColumns = @JoinColumn(name = "id_about"))
    private List<AboutEntity> abouts;
}
