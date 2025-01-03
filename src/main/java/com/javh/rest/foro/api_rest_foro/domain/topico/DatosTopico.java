package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import com.javh.rest.foro.api_rest_foro.domain.curso.DatosCurso;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.DatosRespuesta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.usuario.DatosUsuario;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

//Clase para obtener los datos desde la base de datos y validarlos.
public record DatosTopico(
    @NotNull(message = "Error, el id no existe en la db")
        Long id,
    @NotBlank(message = "Error, el titulo no existe en la db")
        String titulo,
    @NotBlank(message = "Error, el mensaje no existe en la db")
        String mensaje,
    @NotNull(message = "Error, la fechaCreacion no existe en la db")
    @FutureOrPresent(message = "Error, la fecha debe ser actual")
        LocalDateTime fechaCreacion,
    @NotNull(message = "Error, debe de contener un curso existente en la db")
    @Valid
        DatosCurso curso,
    @NotNull(message = "Error, debe de contener un usuario existente en la db")
    @Valid
        DatosUsuario autor,
    @Valid
        List<DatosRespuesta> respuestas
) {
    public DatosTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), new DatosCurso(topico.getCurso()),
             new DatosUsuario(topico.getAutor()), topico.getRespuestas().stream().map(DatosRespuesta::new).toList());
    }
}
