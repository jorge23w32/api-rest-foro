package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.DatosUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public record DatosPerfil(
    @NotNull(message = "Error, el id no existe en la bd")
        Long id,
    @NotNull(message = "Error, el nombre del rol no existe en la bd")
        Rol nombre,
    @Valid
    List<DatosUsuario> usuario
) {
    public  DatosPerfil(Perfil perfil){
        this(perfil.getId(), perfil.getNombre(), perfil.getUsuario().stream().map(DatosUsuario::new).toList());
    }
}
