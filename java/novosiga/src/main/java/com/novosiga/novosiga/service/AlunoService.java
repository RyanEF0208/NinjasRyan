package com.novosiga.novosiga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novosiga.novosiga.model.Aluno;
import com.novosiga.novosiga.repository.AlunoRepository;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    public void deleteById(Integer id){
        alunoRepository.deleteById(id);
    }

    public Aluno findById(Integer id){
        return alunoRepository.findById(id).orElse(null);
    }
}
