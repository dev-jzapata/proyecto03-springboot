package com.jzapata.manejospringdatajpa.entities.entity6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "aerolinea", cascade = CascadeType.REMOVE)
    private List<Vuelo> vuelos = new ArrayList<>();

}
