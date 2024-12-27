package com.javh.rest.foro.api_rest_foro.domain.curso;

import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.List;

public record DatosCurso(
    @NotBlank(message = "Error, el campo no debe de estar vacio")
        String nombre,
    @NotNull(message = "Error, no se pudo obtener la categoria")
        Categoria categoria,
    @Valid
        List<Topico> topicos
) {
}
