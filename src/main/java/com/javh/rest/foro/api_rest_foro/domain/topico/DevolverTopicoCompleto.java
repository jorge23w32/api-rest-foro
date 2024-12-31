package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DevolverTopicoCompleto(
        @NotNull(message = "Error el id no existe")
        Long id,
        @NotBlank(message = "Error no se puede devolver el titulo ya que no existe")
        String titulo,
        @NotBlank(message = "Error no se puede devolver el mensaje ya que no existe")
        String mensaje,
        @NotBlank(message = "Error no se puede devolver la fechaCreacion ya que no existe")
        LocalDateTime fechaCreacion,
        @NotBlank(message = "Error, no se puede devolver el idCurso ya que no existe")
        Long idCurso,
        @NotBlank(message = "Error, no se puede devolver el idAutor ya que no existe")
        Long idAutor,
        @NotBlank(message = "Error, no se puede devolver las respuestas ya que la lista no existe")
        List<Long> respuestas
) {
    public DevolverTopicoCompleto(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getCurso().getId(), topico.getAutor().getId(),
                topico.getRespuestas().stream().map(Respuesta::getId).toList());
    }
}
