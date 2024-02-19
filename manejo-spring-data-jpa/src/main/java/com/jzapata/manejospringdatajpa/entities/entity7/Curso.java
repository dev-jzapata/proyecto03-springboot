package com.jzapata.manejospringdatajpa.entities.entity7;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    //Se utiliza para no tener elementos duplicados
    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos = new HashSet<>();
}
