package com.jzapata.manejospringdatajpa.repositories.repository5;

import com.jzapata.manejospringdatajpa.entities.entity5.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
