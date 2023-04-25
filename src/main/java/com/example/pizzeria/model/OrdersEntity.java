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
    @Column(name = "id_order", nullable = false)
    private Long idOrder;


    /*@Column(name = "id_order")
    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    private UserEntity order;*/

    @OneToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id_address")
    private AddressEntity address;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "user_id")
    private UserEntity user;
    @ManyToMany
    @JoinTable(name = "orders_pizza",
            joinColumns = @JoinColumn(name = "id_order"),
            inverseJoinColumns = @JoinColumn(name = "id_pizza"))
    private List<PizzaEntity> pizzaEntities;




}
