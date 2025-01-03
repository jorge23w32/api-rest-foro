package com.javh.rest.foro.api_rest_foro.domain.curso;

import com.javh.rest.foro.api_rest_foro.domain.topico.DatosTopico;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.List;

public record DatosCurso(
    @NotNull(message = "Error, el id no existe en la db")
        Long id,
    @NotBlank(message = "Error, el nombre no  existe en la db")
        String nombre,
    @NotNull(message = "Error, no se pudo obtener la categoria en la db")
        Categoria categoria,
    @Valid
        List<DatosTopico> topicos
) {
        public DatosCurso(Curso curso){
                this(curso.getId(), curso.getNombre(), curso.getCategoria(), curso.getTopicos().stream().map(DatosTopico::new).toList());
        }
}
