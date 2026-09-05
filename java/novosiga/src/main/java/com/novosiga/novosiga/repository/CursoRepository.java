package com.novosiga.novosiga.repository;

import com.novosiga.novosiga.model.Curso;
import com.novosiga.novosiga.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
