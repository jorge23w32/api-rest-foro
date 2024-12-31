package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.perfil.DatosPerfil;
import com.javh.rest.foro.api_rest_foro.domain.perfil.DevolverPerfil;
import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.perfil.PerfilRepository;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    @Autowired
    private PerfilRepository repository;
    //Listar Perfiles
    @GetMapping
    public ResponseEntity<Page<DevolverPerfil>> mostrarPerfiles(@PageableDefault(size = 5) Pageable pageable){
        var perfiles = repository.findAllPageable(pageable);
        perfiles.forEach(System.out::println);
        var devolverPerfiles = perfiles.map(DevolverPerfil::new);
        return ResponseEntity.ok(devolverPerfiles);
    }
}
