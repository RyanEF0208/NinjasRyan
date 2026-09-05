package com.novosiga.novosiga.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCurso;

    @Column(nullable = false, length = 50)
    private String nomeCurso;

    @Column(nullable = false, length = 50)
    private String descricaoCurso;

    @Column(nullable = false, length = 20)
    private String cargaHoraria;
}
