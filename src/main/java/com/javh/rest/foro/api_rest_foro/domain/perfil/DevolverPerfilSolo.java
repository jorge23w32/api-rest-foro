package com.javh.rest.foro.api_rest_foro.domain.perfil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Metodo para enviar datos solo en actualizar, agregar y eliminar
public record DevolverPerfilSolo(
        @NotBlank(message = "Error, no existe el id en la bd")
        Long id,
        @NotNull(message = "Error, no existe el rol en la bd")
        Rol nombre
) {
    public DevolverPerfilSolo(Perfil perfil){
        this(perfil.getId(), perfil.getNombre());
    }
}
