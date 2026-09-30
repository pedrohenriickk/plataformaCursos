package com.example.plataforma_de_cursos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @Column(length = 150)
    private String email;

    public Aluno(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @ManyToMany
    @JoinTable(
            name = "matricula",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Cursos> cursos = new HashSet<>();
}
