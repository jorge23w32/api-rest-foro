package com.javh.rest.foro.api_rest_foro.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ActualizarTopico(

        String titulo,

        String mensaje,

        Boolean status,

        Long idCurso,
        @NotNull(message = "Error, el id del autor o usuario no debe de estar nulo o vacio")
        Long idAutor
) {
}
