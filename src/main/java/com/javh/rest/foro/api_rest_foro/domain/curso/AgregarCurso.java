package com.javh.rest.foro.api_rest_foro.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgregarCurso(
        @NotBlank(message = "Error, el nombre no debe de estar vacio o nulo")
        String nombre,
        @NotNull(message = "Error, la categoria no debe de ser nula")
        Categoria categoria
) {
}
