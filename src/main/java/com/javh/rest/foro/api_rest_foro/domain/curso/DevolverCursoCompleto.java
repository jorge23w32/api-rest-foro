package com.javh.rest.foro.api_rest_foro.domain.curso;

import com.javh.rest.foro.api_rest_foro.domain.topico.DevolverTopicoSolo;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DevolverCursoCompleto(
        @NotNull(message = "Error, el id no existe en la bd")
        Long id,
        @NotBlank(message = "Error, el nombre no existe en la bd")
        String nombre,
        @NotNull(message = "Error, la categoria no existe en la bd")
        Categoria categoria,
        @NotNull(message = "Error, no hay topicos del curso en la bd")
        List<DevolverTopicoSolo> topicos
) {
    public DevolverCursoCompleto(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria(),
             curso.getTopicos().stream().map(DevolverTopicoSolo::new).toList());
    }

}
