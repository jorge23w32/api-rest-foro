package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.topico.AgregarTopico;
import com.javh.rest.foro.api_rest_foro.service.topico.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService service;

    //Obtener todos los topicos
    @GetMapping
    public ResponseEntity mostrarTopicos(@PageableDefault(size = 5) Pageable pageable){
        return service.mostrarTopicosBuscados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarTopico(@PathVariable Long id){
        return service.mostrarTopicoBuscado(id);
    }

    @PostMapping
    public ResponseEntity agregarTopico(@RequestBody AgregarTopico agregarTopico){
        return service.agregar(agregarTopico);
    }
}
