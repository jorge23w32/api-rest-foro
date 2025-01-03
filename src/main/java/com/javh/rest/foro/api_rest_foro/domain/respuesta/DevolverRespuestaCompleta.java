package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.topico.DevolverTopicoSolo;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioSolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DevolverRespuestaCompleta(
        @NotBlank(message = "Error, no existe el mensaje en la bd")
        String mensaje,
        @NotNull(message = "Error, no existe la fechaCreacion en la bd")
        LocalDateTime fechaCreacion,
        @NotBlank(message = "Error, no existe la solucion en la bd")
        String solucion,
        @NotNull(message = "Error, no existe el idTopico correspondiente en la bd")
        DevolverTopicoSolo topico,
        @NotNull(message = "Error, no existe el idTopico correspondiente en la bd")
        DevolverUsuarioSolo autor
) {
    public DevolverRespuestaCompleta(Respuesta respuesta){
        this(respuesta.getMensaje(), respuesta.getFechaCreacion(),
             respuesta.getSolucion(), new DevolverTopicoSolo(respuesta.getTopico()),
             new DevolverUsuarioSolo(respuesta.getAutor()));
    }
}
