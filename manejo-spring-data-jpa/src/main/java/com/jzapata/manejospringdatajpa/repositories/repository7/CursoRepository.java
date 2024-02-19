package com.jzapata.manejospringdatajpa.repositories.repository7;

import com.jzapata.manejospringdatajpa.entities.entity7.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}
