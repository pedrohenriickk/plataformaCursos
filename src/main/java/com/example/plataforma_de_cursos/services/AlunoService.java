package com.example.plataforma_de_cursos.services;

import com.example.plataforma_de_cursos.DTOs.AlunoDTO;
import com.example.plataforma_de_cursos.entities.Aluno;
import com.example.plataforma_de_cursos.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }


    public String criarAluno(AlunoDTO alu){
        Aluno aluno = new Aluno();
        aluno.setEmail(alu.getEmail());
        aluno.setNome(alu.getNome());
        alunoRepository.save(aluno);
        return "Aluno cadastrado com sucesso!";
    }

    public AlunoDTO buscarAlunoId(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail((aluno.getEmail()));

        return dto;
    }

    public List<AlunoDTO> mostrarAlunos(){
        return alunoRepository.findAll().stream().map(aluno -> new AlunoDTO(aluno.getId(),aluno.getNome(),aluno.getEmail())).toList();
    }

    public String deletarAluno(long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        alunoRepository.deleteById(aluno.getId());
        return "Aluno excluído com sucesso";
    }

    public String alterarDados(Long id,AlunoDTO dto){
        Aluno alterarDados = alunoRepository.findById(id).orElseThrow();
        alterarDados.setNome(dto.getNome());
        alterarDados.setEmail(dto.getEmail());
        alunoRepository.save(alterarDados);

        return "Dados alterados com sucesso!";
    }





}
