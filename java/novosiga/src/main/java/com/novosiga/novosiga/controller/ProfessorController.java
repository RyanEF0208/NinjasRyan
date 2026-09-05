package com.novosiga.novosiga.controller;

import com.novosiga.novosiga.model.Professor;
import com.novosiga.novosiga.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor){
        professorService.save(professor);

        return "redirect:/professores/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);

        return "professor/listarProfessores";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("professor", new Professor());

        return "professor/formularioProfessor";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        professorService.deleteById(id);

        return "redirect:/professor/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Professor professor = professorService.findById(id);
        model.addAttribute("professor", professor);

        return "professor/formularioProfessor";
    }
}
