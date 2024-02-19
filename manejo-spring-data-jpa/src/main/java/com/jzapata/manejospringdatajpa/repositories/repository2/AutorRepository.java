package com.jzapata.manejospringdatajpa.repositories.repository2;

import com.jzapata.manejospringdatajpa.entities.entity2.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
