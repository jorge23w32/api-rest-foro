package com.javh.rest.foro.api_rest_foro.domain.curso;

import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DevolverCurso(
        @NotBlank(message = "Error, el id no existe en la bd")
        Long id,
        @NotBlank(message = "Error, el nombre no existe en la bd")
        String nombre,
        @NotNull(message = "Error, la categoria no existe en la bd")
        Categoria categoria,
        @NotBlank(message = "Error, no hay topicos existentes en la bd")
        List<Long> topicos
) {
    public DevolverCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria(),
             curso.getTopicos().stream().map(Topico::getId).toList());
    }
}
