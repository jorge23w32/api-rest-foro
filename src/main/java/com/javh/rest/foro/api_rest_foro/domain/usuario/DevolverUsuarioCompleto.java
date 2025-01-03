package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.DevolverPerfilSolo;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.DevolverRespuestaSola;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.DevolverTopicoSolo;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DevolverUsuarioCompleto(

        @NotBlank(message = "Error, el nombre no existe en la bd")
        String nombre,
        @NotBlank(message = "Error, el correoElectronico no existe en la bd")
        @Email(message = "Error, el correo electronico propocionado no existe")
        String correoElectronico,
        @NotBlank(message = "Error, la contrasena no existe en la bd")
        String contrasena,
        @NotNull(message = "Error, no existe el perfil correspondiente en la bd")
        DevolverPerfilSolo perfil,
        @NotNull(message = "Error, no existe el idRespuesta correspondiente en la bd")
        List<DevolverRespuestaSola> respuestas,
        @NotNull(message = "Error, no existe el idTopicos correspondiente en la bd")
        List<DevolverTopicoSolo> topicos
) {
    public DevolverUsuarioCompleto(Usuario usuario){
        this(usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getContrasena(),
             new DevolverPerfilSolo(usuario.getPerfil()) ,
             usuario.getRespuestas().stream().map(DevolverRespuestaSola::new).toList(),
             usuario.getTopicos().stream().map(DevolverTopicoSolo::new).toList());
    }
}
