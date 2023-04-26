package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user", schema = "public", catalog = "postgres")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_order",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_order"))
    private List<OrdersEntity> orders;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "address_user",
            joinColumns = @JoinColumn(name = "id_adress"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<AddressEntity> address;



}
