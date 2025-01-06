package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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
    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Usuario> usuario;

    //Constructores
    public Perfil(){

    }
    public Perfil(DatosPerfil datosPerfil){
        this.nombre = datosPerfil.nombre();
        this.usuario = datosPerfil.usuario().stream().map(Usuario::new).toList();
    }
    

    public Perfil(AgregarPerfil agregarPerfil) {
        this.nombre = agregarPerfil.nombre();
    }
    //Getters
    public Long getId() {
        return id;
    }

    public Rol getNombre() {
        return nombre;
    }

    public List<Usuario> getUsuario() {
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

    public void actualizarPerfil(ActualizarPerfil actualizarPerfil) {
        if(actualizarPerfil.nombre() != null){
            this.nombre = actualizarPerfil.nombre();
        }
    }
}
