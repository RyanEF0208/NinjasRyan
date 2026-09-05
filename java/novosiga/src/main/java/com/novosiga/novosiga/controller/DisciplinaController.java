package com.novosiga.novosiga.controller;

import com.novosiga.novosiga.model.Curso;
import com.novosiga.novosiga.model.Disciplina;
import com.novosiga.novosiga.model.Professor;
import com.novosiga.novosiga.service.CursoService;
import com.novosiga.novosiga.service.DisciplinaService;
import com.novosiga.novosiga.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Disciplina disciplina){
        disciplinaService.save(disciplina);

        return "redirect:/disciplina/listarDisciplinas";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Disciplina> disciplina = disciplinaService.findAll();
        model.addAttribute("disciplina", disciplina);

        return "disciplina/listarDisciplinas";
    }

    @GetMapping("/criar")
    public String criarForm(Model model){
        model.addAttribute("disciplina", new Disciplina());
        List<Professor> professors = professorService.findAll();
        model.addAttribute("professores", professors);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "disciplina/formularioDisciplina";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        disciplinaService.deleteById(id);

        return "redirect:/disciplina/listarDisciplinas";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Disciplina disciplina = disciplinaService.findById(id);
        model.addAttribute("disciplina", disciplina);
        List<Professor> professors = professorService.findAll();
        model.addAttribute("professores", professors);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "disciplina/formularioDisciplina";
    }
}
