package com.jzapata.manejospringdatajpa.repositories.repository7;

import com.jzapata.manejospringdatajpa.entities.entity7.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
