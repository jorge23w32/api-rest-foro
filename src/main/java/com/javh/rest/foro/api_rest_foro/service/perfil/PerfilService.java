package com.javh.rest.foro.api_rest_foro.service.perfil;

import com.javh.rest.foro.api_rest_foro.domain.perfil.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository perfilRepository;

    public ResponseEntity mostrarPerfilesBuscados(Pageable pageable){
        var perfiles = perfilRepository.findByActivoTrue(pageable);
        if(perfiles.isEmpty() || perfiles == null){
            return ResponseEntity.badRequest().body("Error, no se pudo obtener los perfiles de la bd, intenta de nuevo");
        }
        var devolverPerfiles = perfiles.map(DevolverPerfilCompleto::new);
        return ResponseEntity.ok(devolverPerfiles);
    }

    public ResponseEntity mostrarPerfilBuscado(Long id) {
        var perfil = perfilRepository.findByIdAndActivoTrue(id).orElse(null);
        if(perfil == null || !perfil.getActivo()){
            return ResponseEntity.badRequest().body("No hay un perfil con ese id");
        }
        var datosPerfil = new DevolverPerfilCompleto(perfil);
        return ResponseEntity.ok(datosPerfil);
    }

    public ResponseEntity agregar(AgregarPerfil agregarPerfil, UriComponentsBuilder builder) {
        var perfil = perfilRepository.save(new Perfil(agregarPerfil));
        var datosPerfil = new DevolverPerfilSolo(perfil);
        URI uri = builder.path("/perfil/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(datosPerfil);
    }

    public ResponseEntity actualizar(Long id, ActualizarPerfil actualizarPerfil){
        var perfil = perfilRepository.findByIdAndActivoTrue(id).orElse(null);
        if(perfil == null || !perfil.getActivo()){
            return ResponseEntity.badRequest().body("Error, el id del perfil no existe en la base de datos");
        }
        perfil = perfilRepository.getReferenceById(id);
        perfil.actualizarPerfil(actualizarPerfil);
        var datosPerfil = new DevolverPerfilSolo(perfil);
        return ResponseEntity.ok(datosPerfil);
    }
}
