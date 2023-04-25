package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

@Table(name = "number", schema = "public", catalog = "postgres")
public class NumberEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_number", nullable = false)
    private long idNumber;
    @Basic
    @Column(name = "number", nullable = true, length = 20)
    private String number;


    @OneToOne(mappedBy = "number")
    private UserEntity user;
}
