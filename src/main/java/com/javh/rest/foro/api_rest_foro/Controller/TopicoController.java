package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.topico.DatosTopico;
import com.javh.rest.foro.api_rest_foro.domain.topico.TopicoRepository;
import com.javh.rest.foro.api_rest_foro.domain.topico.DevolverTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    //Obtener todos los topicos
    @GetMapping
    public ResponseEntity<Page<DevolverTopico>> mostrarTopicos(@PageableDefault(size = 5) Pageable pageable){
        var topicos = topicoRepository.findAllPageable(pageable);
        var datosTopicos = topicos.map(DevolverTopico::new);
        return ResponseEntity.ok(datosTopicos);
    }
}
