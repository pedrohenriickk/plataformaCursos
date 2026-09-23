package com.example.plataforma_de_cursos.services;

import com.example.plataforma_de_cursos.entities.Aluno;
import com.example.plataforma_de_cursos.entities.Cursos;
import com.example.plataforma_de_cursos.repositories.AlunoRepository;
import com.example.plataforma_de_cursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;


    public MatriculaService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String addAlunoCurso(long idAluno, long idCurso){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        Cursos cursos = cursoRepository.findById(idCurso).orElseThrow();
        aluno.criarCurso().add(cursos);
        alunoRepository.save(aluno);
        return "matricula feita com sucesso";
    }
}
