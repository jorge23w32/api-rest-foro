package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.DevolverPerfilSolo;
import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DevolverUsuarioSolo(
        @NotBlank(message = "Error, el id no existe en la bd")
        Long id,
        @NotBlank(message = "Error, el nombre no existe en la bd")
        String nombre,
        @NotBlank(message = "Error, el correoElectronico no existe en la bd")
        @Email(message = "Error, el correo electronico propocionado no existe")
        String correoElectronico,
        @NotBlank(message = "Error, la contrasena no existe en la bd")
        String contrasena,
        @Valid
        DevolverPerfilSolo perfil
) {
    public DevolverUsuarioSolo(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreoElectronico(), usuario.getContrasena(), new DevolverPerfilSolo(usuario.getPerfil()));
    }
}
