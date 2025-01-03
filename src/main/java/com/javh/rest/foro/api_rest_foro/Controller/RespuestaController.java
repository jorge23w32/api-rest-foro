package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.ActualizarRespuesta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.AgregarRespuesta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.DevolverRespuestaCompleta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.RespuestaRepository;
import com.javh.rest.foro.api_rest_foro.service.respuesta.RespuestaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
    @Autowired
    private RespuestaService service;

    @GetMapping
    public ResponseEntity mostrarRespuestas(@PageableDefault(size = 5)Pageable pageable){
        return service.mostrarRespuestasBuscadas(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarRespuesta(@PathVariable @NotNull Long id){
        return service.mostrarRespuestaBuscada(id);
    }

    @PostMapping
    public ResponseEntity agregarRespuesta(@RequestBody @Valid AgregarRespuesta agregarRespuesta, UriComponentsBuilder builder){
        return service.agregar(agregarRespuesta, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid ActualizarRespuesta actualizarRespuesta, @PathVariable @NotNull Long id){
        return service.actualizar(id,actualizarRespuesta);
    }
}
