package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import jakarta.validation.constraints.NotBlank;

public record AgregarRespuesta(
        @NotBlank(message = "El mensaje no debe de estar vacio o nulo")
        String mensaje,
        @NotBlank(message = "La solucion no debe de estar vacio o nulo")
        String solucion,
        @NotBlank(message = "El id no debe de estar vacio o nulo")
        Long autor,
        @NotBlank(message = "El id no debe de estar vacio o nulo")
        Long topico
) {
}
