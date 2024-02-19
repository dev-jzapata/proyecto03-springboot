package com.jzapata.manejospringdatajpa.entities.entity2;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

}
