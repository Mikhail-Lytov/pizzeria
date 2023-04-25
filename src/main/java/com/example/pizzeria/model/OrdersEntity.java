package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "orders", schema = "public", catalog = "postgres")
public class OrdersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany
    @JoinTable(name = "order_pizza",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_pizza")
    )
    private List<PizzaEntity> pizzas;

}
