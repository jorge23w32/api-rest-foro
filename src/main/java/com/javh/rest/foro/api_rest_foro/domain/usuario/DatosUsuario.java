package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record DatosUsuario(
    @NotBlank(message = "Error, el campo no debe de estar vacio")
        String nombre,
    @NotBlank(message = "Error, el campo no debe de estar vacio")
    @Email(message = "Error, el correo electronico propocionado no existe")
        String correoElectronico,
    @NotBlank(message = "Error, el campo no debe de estar vacio")
        String contrasena,
    @NotNull(message = "Error, debes de tener almenos un rol en el foro")
    @Valid
        Set<Perfil> perfiles,
    @Valid
        List<Respuesta> respuestas,
    @Valid
        List<Topico> topicos
) {
}
