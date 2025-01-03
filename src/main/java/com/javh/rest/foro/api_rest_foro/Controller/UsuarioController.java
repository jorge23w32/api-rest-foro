package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.usuario.ActualizarUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.AgregarUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioCompleto;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import com.javh.rest.foro.api_rest_foro.service.usuario.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    //Listar todos los usuario
    @GetMapping
    public ResponseEntity mostrarUsuarios(@PageableDefault(size = 5)Pageable pageable){
            return service.mostrarUsuariosBuscados(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarUsuario(@PathVariable @NotNull Long id){
        return service.mostrarUsuarioBuscado(id);
    }

    @PostMapping
    public ResponseEntity agregarUsuario(@RequestBody @Valid AgregarUsuario agregarUsuario, UriComponentsBuilder builder){
        return service.agregar(agregarUsuario, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarUsuario(@RequestBody @Valid ActualizarUsuario actualizarUsuario, @PathVariable @NotNull Long id){
        return service.actualizar(id, actualizarUsuario);
    }
}
