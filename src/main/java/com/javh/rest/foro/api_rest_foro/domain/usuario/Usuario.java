package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    //Clases Relacionadas
    @OneToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Topico> topicos;

    //Constructores
    public Usuario(DatosUsuario datosUsuario){
        this.nombre = datosUsuario.nombre();
        this.correoElectronico = datosUsuario.correoElectronico();
        this.contrasena = datosUsuario.contrasena();
        this.perfil = new Perfil(datosUsuario.perfil());
        this.respuestas = datosUsuario.respuestas().stream().map(Respuesta::new).toList();
        this.topicos = datosUsuario.topicos().stream().map(Topico::new).toList();
    }
    public Usuario(){
    }

    //Getters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }


    //
//    @Override
//    public String toString() {
//        return "Usuario{" +
//                "id=" + id +
//                ", nombre='" + nombre + '\'' +
//                ", correoElectronico='" + correoElectronico + '\'' +
//                ", contrasena='" + contrasena + '\'' +
//                ", perfil=" + perfil +
//                ", respuestas=" + respuestas +
//                ", topicos=" + topicos +
//                '}';
//    }
}
