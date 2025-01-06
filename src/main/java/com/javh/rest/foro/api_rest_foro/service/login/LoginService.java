package com.javh.rest.foro.api_rest_foro.service.login;

import com.javh.rest.foro.api_rest_foro.domain.usuario.LoginUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import com.javh.rest.foro.api_rest_foro.infra.security.DevolverToken;
import com.javh.rest.foro.api_rest_foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity autenticar(LoginUsuario loginUsuario) {
        try {
            Authentication authenticationTokentoken = new UsernamePasswordAuthenticationToken(
                    loginUsuario.correoElectronico(), loginUsuario.contrasena());
            var usuarioAutenticado = authenticationManager.authenticate(authenticationTokentoken);
            var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new DevolverToken(jwtToken));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(403).body("Error de autenticación: " + e.getMessage());
        }
    }
}
