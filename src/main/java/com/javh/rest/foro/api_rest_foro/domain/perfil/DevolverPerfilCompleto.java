package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioSolo;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DevolverPerfilCompleto(
        @NotNull(message = "Error, no existe el id en la bd")
        Long id,
        @NotNull(message = "Error, no existe el rol en la bd")
        Rol nombre,
        @NotNull(message = "Error, no existe el idUsuario correspondiente en la bd")
        List<DevolverUsuarioSolo> idUsuario
) {
    public DevolverPerfilCompleto(Perfil perfil){
        this(perfil.getId(), perfil.getNombre(), perfil.getUsuario().stream().map(DevolverUsuarioSolo::new).toList());
    }

}
