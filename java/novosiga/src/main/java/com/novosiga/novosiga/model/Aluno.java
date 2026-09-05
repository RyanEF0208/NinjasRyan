package com.novosiga.novosiga.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;

    @Column(nullable = false, length = 50)
    private String nomeAluno;

    @Column(nullable = false, length = 40)
    private String enderecoAluno;

    @Column(nullable = false, length = 30)
    private String cidadeAluno;

    @Column(nullable = false, length = 2)
    private String estadoAluno;

    @Column(nullable = false, length = 14)
    private String cepAluno;

    @Column(nullable = false, length = 14)
    private String telefoneAluno;

    @Column(nullable = false, length = 11)
    private String cpfAluno;

    @Lob
    private byte[] fotoAluno;

    @Column(length = 20)
    private String tipoFoto;

    @ManyToOne
    @JoinColumn(name = "id_Curso_fk")
    private Curso curso;
}

