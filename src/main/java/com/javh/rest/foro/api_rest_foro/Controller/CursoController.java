package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.curso.AgregarCurso;
import com.javh.rest.foro.api_rest_foro.domain.curso.CursoRepository;
import com.javh.rest.foro.api_rest_foro.service.curso.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService service = new CursoService();

    @GetMapping
    public ResponseEntity mostrarCursos(@PageableDefault(size = 5)Pageable pageable){
        return service.mostrarCursosBuscados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarCurso(@PathVariable Long id){
        return service.mostrarCursoBuscado(id);
    }

    //Agrega un curso
    @PostMapping
    public ResponseEntity agregarCurso(@RequestBody @Valid AgregarCurso agregarCurso, UriComponentsBuilder componentsBuilder){
        var response = service.agregar(agregarCurso);
        return response;
    }
}
