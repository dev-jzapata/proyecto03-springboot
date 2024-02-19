package com.jzapata.manejospringdatajpa.repositories.repository1;

import com.jzapata.manejospringdatajpa.entities.entity1.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {


}
