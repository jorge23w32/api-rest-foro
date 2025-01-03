package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.perfil.*;
import com.javh.rest.foro.api_rest_foro.service.perfil.PerfilService;
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
    public ResponseEntity mostrarPerfil(@PathVariable @NotNull Long id){
        return perfilService.mostrarPerfilBuscado(id);
    }

    @PostMapping
    public ResponseEntity agregarPerfil(@RequestBody @Valid AgregarPerfil agregarPerfil, UriComponentsBuilder builder){
        return perfilService.agregar(agregarPerfil, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarPerfil(@RequestBody @Valid ActualizarPerfil actualizarPerfil, @PathVariable @NotNull Long id){
        return perfilService.actualizar(id, actualizarPerfil);
    }
}
