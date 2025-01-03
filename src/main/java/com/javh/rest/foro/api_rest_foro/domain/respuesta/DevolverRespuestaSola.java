package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.topico.DevolverTopicoSolo;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioSolo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DevolverRespuestaSola(
        @NotBlank(message = "Error, no existe el mensaje en la bd")
        String mensaje,
        @NotNull(message = "Error, no existe la fechaCreacion en la bd")
        LocalDateTime fechaCreacion,
        @NotBlank(message = "Error, no existe la solucion en la bd")
        String solucion,
        @Valid
        DevolverTopicoSolo topico,
        @Valid
        DevolverUsuarioSolo autor
) {
    public DevolverRespuestaSola(Respuesta respuesta){
        this(respuesta.getMensaje(), respuesta.getFechaCreacion(),
                respuesta.getSolucion(), new DevolverTopicoSolo(respuesta.getTopico()), new DevolverUsuarioSolo(respuesta.getAutor()));
    }
}
