package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgregarRespuesta(
        @NotBlank(message = "El mensaje no debe de estar vacio o nulo")
        String mensaje,
        @NotBlank(message = "La solucion no debe de estar vacio o nulo")
        String solucion,
        @NotNull(message = "El id no debe de estar vacio o nulo")
        Long autor,
        @NotNull(message = "El id no debe de estar vacio o nulo")
        Long topico
) {
}
