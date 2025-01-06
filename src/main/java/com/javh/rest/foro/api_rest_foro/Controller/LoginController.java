package com.javh.rest.foro.api_rest_foro.Controller;

import com.javh.rest.foro.api_rest_foro.domain.usuario.LoginUsuario;
import com.javh.rest.foro.api_rest_foro.service.login.LoginService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@SecurityRequirement(name = "bearer-key")
public class LoginController {

    @Autowired
    private LoginService service;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid LoginUsuario loginUsuario){
        return service.autenticar(loginUsuario);
    }
}




























