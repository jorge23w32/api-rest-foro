package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.usuario.AgregarUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioCompleto;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import com.javh.rest.foro.api_rest_foro.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity mostrarUsuario(@PathVariable Long id){
        return service.mostrarUsuarioBuscado(id);
    }

    @PostMapping
    public ResponseEntity agregarUsuario(@RequestBody AgregarUsuario agregarUsuario){
        return service.agregar(agregarUsuario);
    }
}
