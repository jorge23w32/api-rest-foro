package com.javh.rest.foro.api_rest_foro.domain.curso;

import jakarta.validation.constraints.NotNull;

public record ActualizarCurso(
        String nombre,

        Categoria categoria

) {
}
