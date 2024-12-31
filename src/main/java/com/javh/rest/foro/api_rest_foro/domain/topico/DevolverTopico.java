package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DevolverTopico(
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
    public DevolverTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(),
             topico.getCurso().getId(), topico.getAutor().getId(),
             topico.getRespuestas().stream().map(Respuesta::getId).toList());
    }
}
