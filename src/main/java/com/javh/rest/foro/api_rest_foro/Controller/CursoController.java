package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.curso.CursoRepository;
import com.javh.rest.foro.api_rest_foro.domain.curso.DevolverCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository repository;

    @GetMapping
    public ResponseEntity<Page<DevolverCurso>> mostrarCursos(@PageableDefault(size = 5)Pageable pageable){
        var cursos = repository.findAllPegable(pageable);
        var datosCursos = cursos.map(DevolverCurso::new);
        return ResponseEntity.ok(datosCursos);
    }
}
