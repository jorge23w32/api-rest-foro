package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record DatosPerfil(
    @NotNull(message = "Error, al obtener el nombre del rol")
        Rol nombre,
    @Valid
        Set<Usuario> usuarios
) {
}
