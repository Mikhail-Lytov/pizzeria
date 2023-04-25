package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "User", schema = "public", catalog = "postgres")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "year_of_birth", nullable = false)
    private int yearOfBirth;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<AddressEntity> addresses;

    @OneToOne
    @JoinColumn(name = "number_id", referencedColumnName = "id_number")
    private NumberEntity number;
}
