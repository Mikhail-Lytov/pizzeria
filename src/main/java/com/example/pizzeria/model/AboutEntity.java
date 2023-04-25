package com.example.pizzeria.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "about", schema = "public", catalog = "postgres")
public class AboutEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_about", nullable = false)
    private long idAbout;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

}
