package com.example.plataforma_de_cursos.DTOs;


import com.example.plataforma_de_cursos.entities.Cursos;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private long id;
    @NotBlank
    private String nome;
    @NotNull
    private int cargahr;

    public CursoDTO(String nome, int cargahr) {
        this.nome = nome;
        this.cargahr = cargahr;
    }

    public CursoDTO(Cursos cursos) {
        this.id = cursos.getId();
        this.nome = cursos.getNome();
        this.cargahr = cursos.getCargahr();
    }
}
