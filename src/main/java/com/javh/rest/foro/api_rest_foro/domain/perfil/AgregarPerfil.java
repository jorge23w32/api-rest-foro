package com.javh.rest.foro.api_rest_foro.domain.perfil;

import jakarta.validation.constraints.NotNull;

public record AgregarPerfil(
        @NotNull(message = "El nombre de rol no debe de estar nulo o vacio")
        Rol nombre
) {
}
