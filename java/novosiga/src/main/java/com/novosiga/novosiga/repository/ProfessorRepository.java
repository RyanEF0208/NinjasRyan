package com.novosiga.novosiga.repository;

import com.novosiga.novosiga.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
