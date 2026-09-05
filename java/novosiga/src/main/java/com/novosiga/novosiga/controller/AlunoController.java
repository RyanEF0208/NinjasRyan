package com.novosiga.novosiga.controller;

import com.novosiga.novosiga.model.Curso;
import com.novosiga.novosiga.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import com.novosiga.novosiga.service.AlunoService;
import com.novosiga.novosiga.model.Aluno;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartException;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno, @RequestParam("foto") MultipartFile foto) {
        try {
            if(!foto.isEmpty()){
                aluno.setFotoAluno(foto.getBytes());
                aluno.setTipoFoto(foto.getContentType());
            } else if(aluno.getIdAluno() != null){
                Aluno alunoExistente = alunoService.findById(aluno.getIdAluno());

                if(alunoExistente != null){
                    aluno.setFotoAluno(alunoExistente.getFotoAluno());
                    aluno.setTipoFoto(alunoExistente.getTipoFoto());
                }
            }
            alunoService.save(aluno);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/alunos/listar";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);

        return "aluno/listarAlunos";
    }

    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "aluno/formularioAluno";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id){
        alunoService.deleteById(id);

        return "redirect:/alunos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model){
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "aluno/formularioAluno";
    }

    @GetMapping("/foto/{id}")
        public ResponseEntity<byte[]> foto(@PathVariable Integer id){
        Aluno aluno = alunoService.findById(id);
        if (aluno == null || aluno.getFotoAluno() == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(aluno.getTipoFoto()))
                .body(aluno.getFotoAluno());
    }
}
