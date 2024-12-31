package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;



@Entity(name = "Perfil")
@Table(name = "perfiles")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Rol nombre;
//  Clases relacionadas
    @OneToOne(mappedBy = "perfil", cascade = CascadeType.ALL)
    private Usuario usuario;

    //Constructores
    public Perfil(DatosPerfil datosPerfil){
        this.nombre = datosPerfil.nombre();
        this.usuario = new Usuario(datosPerfil.usuario());
    }
    public Perfil(){

    }

    //Getters
    public Long getId() {
        return id;
    }

    public Rol getNombre() {
        return nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

        @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", usuario=" + usuario +
                '}';
    }
}
