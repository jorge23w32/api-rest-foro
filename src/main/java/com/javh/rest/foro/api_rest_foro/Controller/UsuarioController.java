package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    //Listar todos los usuario
    @GetMapping
    public ResponseEntity<Page<DevolverUsuario>> mostrarUsuarios(@PageableDefault(size = 5)Pageable pageable){
            var usuarios = repository.findAllPageable(pageable);
            var datosUsuarios = usuarios.map(DevolverUsuario::new);
            return ResponseEntity.ok(datosUsuarios);
    }
}
