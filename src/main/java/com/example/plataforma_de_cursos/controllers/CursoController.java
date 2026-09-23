package com.example.plataforma_de_cursos.controllers;

import com.example.plataforma_de_cursos.DTOs.AlunoDTO;
import com.example.plataforma_de_cursos.DTOs.CursoDTO;
import com.example.plataforma_de_cursos.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {
    private CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveCurso(@Valid @RequestBody CursoDTO cur){
        return ResponseEntity.ok(service.criarCurso(cur));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCursoId(@PathVariable long id){
        return ResponseEntity.ok().body(service.buscarCursoID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCursos(@PathVariable long id){
        service.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> mostrarCurso(){


        return ResponseEntity.ok(service.mostrarCurso());


    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCurso(@PathVariable long id, @RequestBody CursoDTO cur){
        return ResponseEntity.ok(service.alterarCurso(id,cur));
    }


}
