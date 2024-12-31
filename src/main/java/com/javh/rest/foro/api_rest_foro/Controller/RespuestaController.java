package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.AgregarRespuesta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.DevolverRespuestaCompleta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.RespuestaRepository;
import com.javh.rest.foro.api_rest_foro.service.respuesta.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity mostrarRespuesta(@PathVariable Long id){
        return service.mostrarRespuestaBuscada(id);
    }

    @PostMapping
    public ResponseEntity agregarRespuesta(@RequestBody AgregarRespuesta agregarRespuesta){
        return service.agregar(agregarRespuesta);
    }
}
