package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DevolverUsuarioCompleto(
        @NotBlank(message = "Error, el id no existe en la bd")
        Long id,
        @NotBlank(message = "Error, el nombre no existe en la bd")
        String nombre,
        @NotBlank(message = "Error, el correoElectronico no existe en la bd")
        @Email(message = "Error, el correo electronico propocionado no existe")
        String correoElectronico,
        @NotBlank(message = "Error, la contrasena no existe en la bd")
        String contrasena,
        @NotBlank(message = "Error, no existe el idPerfil correspondiente en la bd")
        Long idpPerfil,
        @NotBlank(message = "Error, no existe el idRespuesta correspondiente en la bd")
        List<Long> idRespuestas,
        @NotBlank(message = "Error, no existe el idTopicos correspondiente en la bd")
        List<Long> idTopicos
) {
    public DevolverUsuarioCompleto(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getContrasena(),
             usuario.getPerfil().getId() ,usuario.getRespuestas().stream().map(Respuesta::getId).toList(),
             usuario.getTopicos().stream().map(Topico::getId).toList());
    }
}
