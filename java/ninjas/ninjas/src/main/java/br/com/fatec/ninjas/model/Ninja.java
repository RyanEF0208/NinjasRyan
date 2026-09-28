package br.com.fatec.ninjas.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;

@Data
@Entity
@Table(name = "ninja")
public class Ninja {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ninja;
    @Column(name = "nome_ninja", nullable = false)
    private String nome;
    @Column(name = "cpf_ninja", nullable = false, unique = true)
    private String cpf;
    @Column(name = "email_ninja", nullable = false, unique = true)
    private String email;
}
