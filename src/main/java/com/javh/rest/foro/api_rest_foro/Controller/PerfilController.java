package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.perfil.*;
import com.javh.rest.foro.api_rest_foro.service.perfil.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private PerfilService perfilService;
    //Listar Perfiles
    @GetMapping
    public ResponseEntity mostrarPerfiles(@PageableDefault(size = 5) Pageable pageable){
        return perfilService.mostrarPerfilesBuscados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarPerfil(@PathVariable Long id){
        return perfilService.mostrarPerfilBuscado(id);
    }

    @PostMapping
    public ResponseEntity agregarPerfil(@RequestBody AgregarPerfil agregarPerfil){
        return perfilService.agregar(agregarPerfil);
    }
}
