package com.example.plataforma_de_cursos.controllers;

import com.example.plataforma_de_cursos.DTOs.AlunoDTO;
import com.example.plataforma_de_cursos.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    private final AlunoService service;


    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveAluno(@RequestBody AlunoDTO dto){
        return ResponseEntity.ok(service.criarAluno(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAlunoId(@PathVariable long id){
        return ResponseEntity.ok().body(service.buscarAlunoId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAlunos(@PathVariable long id){
        service.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> mostrarAlunos(){


        return ResponseEntity.ok(service.mostrarAlunos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarProduto(@PathVariable long id, @RequestBody AlunoDTO dto){
        return ResponseEntity.ok(service.alterarDados(id,dto));
    }








}
