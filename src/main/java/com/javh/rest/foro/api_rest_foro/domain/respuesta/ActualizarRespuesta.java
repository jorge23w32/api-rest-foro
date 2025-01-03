package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarRespuesta(

        String mensaje,

        String solucion,
        @NotNull(message = "Error, debe de contener el id del autor o usuario")
        Long idAutor
) {
}
