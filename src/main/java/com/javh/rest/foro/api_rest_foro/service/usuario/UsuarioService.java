package com.javh.rest.foro.api_rest_foro.service.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.PerfilRepository;
import com.javh.rest.foro.api_rest_foro.domain.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    public ResponseEntity mostrarUsuariosBuscados(Pageable pageable) {
        var usuarios = usuarioRepository.findAllPageable(pageable);
        if(usuarios.isEmpty() || usuarios == null){
            return ResponseEntity.badRequest().body("Error, no se pudieron obtener los usuarios de la bd, intente de nuevo");
        }
        var datosUsuarios = usuarios.map(DevolverUsuarioCompleto::new);
        return ResponseEntity.ok(datosUsuarios);
    }

    public ResponseEntity mostrarUsuarioBuscado(Long id) {
        var usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario == null){
            return ResponseEntity.badRequest().body("El usuario con el id mencionado no existe");
        }
        var datosUsuario = new DevolverUsuarioCompleto(usuario);
        return ResponseEntity.ok(datosUsuario);
    }

    public ResponseEntity agregar(AgregarUsuario agregarUsuario){
        var perfil = perfilRepository.findById(agregarUsuario.perfil()).orElse(null);
        if(perfil == null){
            return ResponseEntity.badRequest().body("Error, no existe el perfil en la bd, verfiica que lo escribiste correctamente o intentalo de nuevo");
        }
        var usuario = usuarioRepository.save(new Usuario(agregarUsuario, perfil));
        var datosUsuario = new DevolverUsuarioSolo(usuario);
        return ResponseEntity.ok(datosUsuario);
    }
}