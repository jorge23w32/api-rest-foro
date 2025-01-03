package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.DatosPerfil;
import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.DatosRespuesta;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.DatosTopico;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

public record DatosUsuario(
    @NotNull(message = "Error, el id no existe en la bd")
        Long id,
    @NotBlank(message = "Error, el nombre no existe en la db")
        String nombre,
    @NotBlank(message = "Error, el correoElectronico no existe en la db")
    @Email(message = "Error, el correo electronico propocionado no existe")
        String correoElectronico,
    @NotBlank(message = "Error, la constrasena no existe en la db")
        String contrasena,
    @NotNull(message = "Error, el rol no existe en la bd")
    @Valid
    DatosPerfil perfil,
    @Valid
        List<DatosRespuesta> respuestas,
    @Valid
        List<DatosTopico> topicos
) {
    public DatosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getContrasena(),
             new DatosPerfil(usuario.getPerfil()), usuario.getRespuestas().stream().map(DatosRespuesta::new).toList(),
             usuario.getTopicos().stream().map(DatosTopico::new).toList());
    }

}
