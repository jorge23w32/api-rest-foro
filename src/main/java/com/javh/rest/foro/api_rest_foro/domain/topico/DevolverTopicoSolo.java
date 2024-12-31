package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.DevolverCursoSolo;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioSolo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DevolverTopicoSolo(
        @NotNull(message = "Error el id no existe")
        Long id,
        @NotBlank(message = "Error no se puede devolver el titulo ya que no existe")
        String titulo,
        @NotBlank(message = "Error no se puede devolver el mensaje ya que no existe")
        String mensaje,
        @NotBlank(message = "Error no se puede devolver la fechaCreacion ya que no existe")
        LocalDateTime fechaCreacion,
        @Valid
        DevolverCursoSolo curso,
        @Valid
        DevolverUsuarioSolo usuario
) {
    public DevolverTopicoSolo(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
             new DevolverCursoSolo(topico.getCurso()), new DevolverUsuarioSolo(topico.getAutor()));
    }
}
