package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

//Clase para obtener los datos desde la base de datos y validarlos.
public record DatosTopico(
    @NotBlank(message = "Error, el campo debe de contener algo")
        String titulo,
    @NotBlank(message = "Error, el campo debe de contener algo")
        String mensaje,
    @NotBlank(message = "Error, el campo debe de contener algo")
    @FutureOrPresent(message = "Error, la fecha debe ser actual")
        LocalDateTime fechaCreacion,
    @NotBlank(message = "Error, el campo debe de contener algo")
        String autor,
    @NotNull(message = "Error, debe de contener un curso")
    @Valid
        Curso curso,
    @NotNull(message = "Error, debe de contener un usuario")
    @Valid
        Usuario usuario,
    @Valid
        List<Respuesta> listaRespuestas
) {
}
