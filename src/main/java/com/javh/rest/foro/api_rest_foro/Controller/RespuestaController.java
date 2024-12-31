package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.DevolverRespuesta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
    @Autowired
    private RespuestaRepository repository;

    @GetMapping
    public ResponseEntity<Page<DevolverRespuesta>> mostrarRespuestas(@PageableDefault(size = 5)Pageable pageable){
        var respuestas = repository.finAllPageable(pageable);
        var datosRespuestas = respuestas.map(DevolverRespuesta::new);
        return ResponseEntity.ok(datosRespuestas);
    }
}
