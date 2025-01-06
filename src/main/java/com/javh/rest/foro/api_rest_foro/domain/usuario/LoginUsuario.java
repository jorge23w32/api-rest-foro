package com.javh.rest.foro.api_rest_foro.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginUsuario(
        @NotBlank(message = "Error, el correo no debe de estar vacio")
        @Email(message = "Error, este correo no es valido")
        String correoElectronico,
        @NotBlank(message = "Error, la contrasena no debe de estar vacio")
        String contrasena
) {
}
