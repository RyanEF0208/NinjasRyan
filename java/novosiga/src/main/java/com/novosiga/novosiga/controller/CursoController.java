package com.novosiga.novosiga.controller;

import com.novosiga.novosiga.model.Curso;
import com.novosiga.novosiga.model.Professor;
import com.novosiga.novosiga.repository.CursoRepository;
import com.novosiga.novosiga.service.CursoService;
import com.novosiga.novosiga.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Curso curso){
        cursoService.save(curso);

        return "redirect:/cursos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);

        return "curso/listarCursos";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("curso", new Curso());

        return "curso/formularioCurso";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        cursoService.deleteById(id);

        return "redirect:/curso/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Curso curso = cursoService.findById(id);
        model.addAttribute("curso", curso);

        return "curso/formularioCurso";
    }
}
