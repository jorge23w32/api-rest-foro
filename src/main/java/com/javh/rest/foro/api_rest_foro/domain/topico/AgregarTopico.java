package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record AgregarTopico(
        @NotBlank(message = "Error no se puede devolver el titulo ya que no existe")
        String titulo,
        @NotBlank(message = "Error no se puede devolver el mensaje ya que no existe")
        String mensaje,
        @NotNull(message = "Error, no se puede devolver el idCurso ya que no existe")
        Long idCurso,
        @NotNull(message = "Error, no se puede devolver el idAutor ya que no existe")
        Long idAutor
) {
}
