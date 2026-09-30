package com.example.plataforma_de_cursos.controllers;

import com.example.plataforma_de_cursos.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matricula")
public class MatriculaController {
    private final MatriculaService service;
    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criarMat(@RequestParam long idAluno, @RequestParam long idCurso){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.addAlunoCurso(idAluno,idCurso));
    }
}
