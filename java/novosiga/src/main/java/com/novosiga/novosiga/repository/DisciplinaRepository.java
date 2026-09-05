package com.novosiga.novosiga.repository;

import com.novosiga.novosiga.model.Disciplina;
import com.novosiga.novosiga.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}
