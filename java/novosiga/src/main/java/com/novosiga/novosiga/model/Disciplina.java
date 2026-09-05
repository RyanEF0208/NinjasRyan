package com.novosiga.novosiga.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idDisciplina;

    @Column(nullable = false, length = 50)
    private String nomeDisciplina;

    @Column(nullable = false, length = 10)
    private String siglaDisciplina;

    @Column(nullable = false, length = 20)
    private String cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "id_Professor_fk")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "id_Curso_fk")
    private Curso curso;
}
