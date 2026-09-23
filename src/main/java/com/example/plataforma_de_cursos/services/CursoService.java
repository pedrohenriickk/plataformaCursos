package com.example.plataforma_de_cursos.services;

import com.example.plataforma_de_cursos.DTOs.CursoDTO;
import com.example.plataforma_de_cursos.entities.Aluno;
import com.example.plataforma_de_cursos.entities.Cursos;
import com.example.plataforma_de_cursos.repositories.AlunoRepository;
import com.example.plataforma_de_cursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String criarCurso(CursoDTO cur){
        Cursos curso = new Cursos();
        curso.setNome(cur.getNome());
        curso.setCargahr(cur.getCargahr());
        cursoRepository.save(curso);
        return "Curso cadastrado com sucesso!";
    }

    public CursoDTO buscarCursoID(Long id){
        Cursos cursos = cursoRepository.findById(id).orElseThrow();
        CursoDTO dto = new CursoDTO();
        dto.setId(cursos.getId());
        dto.setNome(cursos.getNome());
        dto.setCargahr(cursos.getCargahr());

        return dto;

    }

    public List<CursoDTO> mostrarCurso(){
        return cursoRepository.findAll().stream().map(cursos -> new CursoDTO(cursos.getId(),cursos.getNome(),cursos.getCargahr())).toList();
    }

    public String alterarCurso(Long id,CursoDTO dto){
        Cursos alterarCurso = cursoRepository.findById(id).orElseThrow();
        alterarCurso.setNome(dto.getNome());
        alterarCurso.setCargahr(dto.getCargahr());
        cursoRepository.save(alterarCurso);

        return "Curso alterado com sucesso!";
    }

    public String deletarCurso(long id){
        Cursos cursos = cursoRepository.findById(id).orElseThrow();
        cursoRepository.deleteById(cursos.getId());
        return "Curso excluído com sucesso";
    }









}
