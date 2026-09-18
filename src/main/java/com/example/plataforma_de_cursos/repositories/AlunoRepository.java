package com.example.plataforma_de_cursos.repositories;

import com.example.plataforma_de_cursos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
