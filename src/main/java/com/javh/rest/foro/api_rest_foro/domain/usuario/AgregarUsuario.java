package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.DevolverPerfilSolo;
import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgregarUsuario(
        @NotBlank(message = "Error, el nombre no existe en la bd")
        String nombre,
        @NotBlank(message = "Error, el correoElectronico no existe en la bd")
        @Email(message = "Error, el correo electronico propocionado no existe")
        String correoElectronico,
        @NotBlank(message = "Error, la contrasena no existe en la bd")
        String contrasena,
        @NotNull(message = "Error, no existe el idPerfil correspondiente en la bd")
        Long perfil
) {
}
