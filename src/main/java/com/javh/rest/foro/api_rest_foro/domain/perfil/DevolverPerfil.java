package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DevolverPerfil(
        @NotBlank(message = "Error, no existe el id en la bd")
        Long id,
        @NotNull(message = "Error, no existe el rol en la bd")
        Rol nombre,
        @NotBlank(message = "Error, no existe el idUsuario correspondiente en la bd")
        Long idUsuario
) {
    public DevolverPerfil(Perfil perfil){
        this(perfil.getId(), perfil.getNombre(), perfil.getUsuario().getId());
    }

}
