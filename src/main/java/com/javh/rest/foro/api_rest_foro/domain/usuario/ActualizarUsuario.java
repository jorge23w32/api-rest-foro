package com.javh.rest.foro.api_rest_foro.domain.usuario;


public record ActualizarUsuario(

        String nombre,

        String correoElectronico,

        String contrasena,

        Long idPerfil
) {
}
