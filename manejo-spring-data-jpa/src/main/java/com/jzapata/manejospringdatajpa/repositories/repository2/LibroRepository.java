package com.jzapata.manejospringdatajpa.repositories.repository2;

import com.jzapata.manejospringdatajpa.entities.entity2.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
