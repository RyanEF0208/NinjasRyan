package com.novosiga.novosiga.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProfessor;

    @Column(nullable = false, length = 50)
    private String nomeProfessor;

    @Column(nullable = false, length = 11)
    private String cpfProfessor;

    @Column(nullable = false, length = 9)
    private String rgProfessor;

    @Column(nullable = false, length = 14)
    private String telefoneProfessor;

    @Column(nullable = false, length = 40)
    private String enderecoProfessor;

    @Column(nullable = false, length = 50)
    private String graduacaoProfessor;
}
