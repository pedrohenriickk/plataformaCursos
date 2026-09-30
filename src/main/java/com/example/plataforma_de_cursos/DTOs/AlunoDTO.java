package com.example.plataforma_de_cursos.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    private Set<CursoDTO> cursos = new HashSet<>();
    @NotBlank @Email
    @Column(length = 150)
    private String email;

    public AlunoDTO(String nome, Set<CursoDTO> cursos, String email) {
        this.nome = nome;
        this.cursos = cursos;
        this.email = email;
    }

    public AlunoDTO(String email, String nome, long id) {
        this.email = email;
        this.nome = nome;
        this.id = id;
    }


}
