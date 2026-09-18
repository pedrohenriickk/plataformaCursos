package com.example.plataforma_de_cursos.repositories;

import com.example.plataforma_de_cursos.entities.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Cursos,Long> {
}
