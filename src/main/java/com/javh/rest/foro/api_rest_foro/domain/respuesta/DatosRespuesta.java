package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.topico.DatosTopico;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DatosUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(
        @NotBlank(message = "Error, el id no existe en la bd")
            Long id,
        @NotBlank(message = "Error, el mensaje no existe en la bd")
            String mensaje,
        @NotBlank(message = "Error, la fechaCreacion no existe en la bd")
        @FutureOrPresent(message = "Error, la fechaCreacion debe de ser actual")
            LocalDateTime fechaCreacion,
        @NotBlank(message = "Error, la solucion no existe en la bd")
            String solucion,
        @NotNull(message = "Error, para realizar una respuesta debe de tener un topico en la db")
        @Valid
            DatosTopico topico,
        @NotNull(message = "Error, para realizar una respuesta debe de tener un usuario en la db")
        @Valid
            DatosUsuario autor
) {
    public DatosRespuesta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(), respuesta.getSolucion(),
             new DatosTopico(respuesta.getTopico()), new DatosUsuario(respuesta.getAutor()));
    }
}
