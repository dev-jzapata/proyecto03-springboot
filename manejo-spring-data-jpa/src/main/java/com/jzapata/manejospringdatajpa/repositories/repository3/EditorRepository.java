package com.jzapata.manejospringdatajpa.repositories.repository3;

import com.jzapata.manejospringdatajpa.entities.entity3.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
}
