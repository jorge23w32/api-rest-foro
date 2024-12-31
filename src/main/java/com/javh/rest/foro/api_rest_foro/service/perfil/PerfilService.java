package com.javh.rest.foro.api_rest_foro.service.perfil;

import com.javh.rest.foro.api_rest_foro.domain.perfil.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository repository;

    public ResponseEntity mostrarPerfilesBuscados(Pageable pageable){
        var perfiles = repository.findAllPageable(pageable);
        if(perfiles.isEmpty() || perfiles == null){
            return ResponseEntity.badRequest().body("Error, no se pudo obtener los perfiles de la bd, intenta de nuevo");
        }
        var devolverPerfiles = perfiles.map(DevolverPerfilCompleto::new);
        return ResponseEntity.ok(devolverPerfiles);
    }

    public ResponseEntity mostrarPerfilBuscado(Long id) {
        var perfil = repository.findById(id).orElse(null);
        if(perfil == null){
            return ResponseEntity.badRequest().body("No hay un perfil con ese id");
        }
        var datosPerfil = new DevolverPerfilCompleto(perfil);
        return ResponseEntity.ok(datosPerfil);
    }

    public ResponseEntity agregar(AgregarPerfil agregarPerfil) {
        var perfil = repository.save(new Perfil(agregarPerfil));
        var datosPerfil = new DevolverPerfilSolo(perfil);
        return ResponseEntity.ok(datosPerfil);
    }
}
