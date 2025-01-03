package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.DevolverRespuestaSola;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DevolverUsuarioSolo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DevolverTopicoCompleto(

        @NotBlank(message = "Error no se puede devolver el titulo ya que no existe")
        String titulo,
        @NotBlank(message = "Error no se puede devolver el mensaje ya que no existe")
        String mensaje,
        @NotNull(message = "Error no se puede devolver la fechaCreacion ya que no existe")
        LocalDateTime fechaCreacion,
        @NotNull(message = "Error, no se puede devolver el idCurso ya que no existe")
        Curso curso,
        @NotNull(message = "Error, no se puede devolver el idAutor ya que no existe")
        DevolverUsuarioSolo autor,
        @NotNull(message = "Error, no se puede devolver las respuestas ya que la lista no existe")
        List<DevolverRespuestaSola> respuestas
) {
    public DevolverTopicoCompleto(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
                topico.getCurso(), new DevolverUsuarioSolo(topico.getAutor()),
                topico.getRespuestas().stream().map(DevolverRespuestaSola::new).toList());
    }
}
