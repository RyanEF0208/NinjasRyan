package com.novosiga.novosiga.service;

import com.novosiga.novosiga.model.Professor;
import com.novosiga.novosiga.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(Professor professor){ return professorRepository.save(professor); }

    public List<Professor> findAll() { return professorRepository.findAll(); }

    public void deleteById(Integer id) { professorRepository.deleteById(id); }

    public Professor findById(Integer id) { return professorRepository.findById(id).orElse(null); }
}
