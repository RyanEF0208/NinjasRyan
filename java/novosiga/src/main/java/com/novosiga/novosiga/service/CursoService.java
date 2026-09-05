package com.novosiga.novosiga.service;

import com.novosiga.novosiga.model.Aluno;
import com.novosiga.novosiga.model.Curso;
import com.novosiga.novosiga.repository.AlunoRepository;
import com.novosiga.novosiga.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso){
        return cursoRepository.save(curso);
    }

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public void deleteById(Integer id){
        cursoRepository.deleteById(id);
    }

    public Curso findById(Integer id){
        return cursoRepository.findById(id).orElse(null);
    }
}
