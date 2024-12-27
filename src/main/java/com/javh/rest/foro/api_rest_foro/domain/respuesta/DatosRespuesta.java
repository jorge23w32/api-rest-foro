package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(
        @NotBlank(message = "Error, los campos no deben de estar vacios")
            String mensaje,
        @NotBlank(message = "Error, los campos no deben de estar vacios")
        @FutureOrPresent(message = "Error, la fecha debe de ser actual")
            LocalDateTime fechaCreacion,
        @NotBlank(message = "Error, los campos no deben de estar vacios")
            String autor,
        @NotBlank(message = "Error, los campos no deben de estar vacios")
            String solucion,
        @NotNull(message = "Error, para realizar una respuesta debe de tener un topico")
        @Valid
            Topico topico,
        @NotNull(message = "Error, para realizar una respuesta debe de tener un usuario")
        @Valid
            Usuario usuario
) {
}
