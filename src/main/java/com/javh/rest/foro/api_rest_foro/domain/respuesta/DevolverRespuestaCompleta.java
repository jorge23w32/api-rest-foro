package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DevolverRespuestaCompleta(
        @NotBlank(message = "Error, no existe el id en la bd")
        Long id,
        @NotBlank(message = "Error, no existe el mensaje en la bd")
        String mensaje,
        @NotBlank(message = "Error, no existe la fechaCreacion en la bd")
        LocalDateTime fechaCreacion,
        @NotBlank(message = "Error, no existe la solucion en la bd")
        String solucion,
        @NotBlank(message = "Error, no existe el idTopico correspondiente en la bd")
        Long idTopico,
        @NotNull(message = "Error, no existe el idTopico correspondiente en la bd")
        Long idAutor
) {
    public DevolverRespuestaCompleta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(),
             respuesta.getSolucion(), respuesta.getTopico().getId(),respuesta.getAutor().getId());
    }
}
