package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.topico.ActualizarTopico;
import com.javh.rest.foro.api_rest_foro.domain.topico.AgregarTopico;
import com.javh.rest.foro.api_rest_foro.service.topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoService service;

    //Obtener todos los topicos
    @GetMapping
    public ResponseEntity mostrarTopicos(@PageableDefault(size = 5) Pageable pageable){
        return service.mostrarTopicosBuscados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarTopico(@PathVariable @NotNull Long id){
        return service.mostrarTopicoBuscado(id);
    }

    @PostMapping
    public ResponseEntity agregarTopico(@RequestBody @Valid AgregarTopico agregarTopico, UriComponentsBuilder builder){
        return service.agregar(agregarTopico, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid ActualizarTopico actualizarTopico, @PathVariable @NotNull Long id){
        return service.actualizar(id,actualizarTopico);
    }
}
