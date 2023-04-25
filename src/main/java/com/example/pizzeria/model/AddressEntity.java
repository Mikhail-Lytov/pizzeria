package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "address", schema = "public", catalog = "postgres")
public class AddressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_address", nullable = false)
    private int idAddress;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "user_id")
    private UserEntity user;

}
