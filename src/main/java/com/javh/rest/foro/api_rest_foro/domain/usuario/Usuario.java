package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true)
    private String correoElectronico;
    private String contrasena;
    //Clases Relacionadas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id", nullable = false)
    private Perfil perfil;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Topico> topicos;


    //Constructores
    public Usuario(){

    }
    public Usuario(DatosUsuario datosUsuario){
        this.nombre = datosUsuario.nombre();
        this.correoElectronico = datosUsuario.correoElectronico();
        this.contrasena = datosUsuario.contrasena();
        this.perfil = new Perfil(datosUsuario.perfil());
        this.respuestas = datosUsuario.respuestas().stream().map(Respuesta::new).toList();
        this.topicos = datosUsuario.topicos().stream().map(Topico::new).toList();
    }
    public Usuario(AgregarUsuario agregarUsuario, Perfil perfil){
        this.nombre = agregarUsuario.nombre();
        this.correoElectronico = agregarUsuario.correoElectronico();
        this.contrasena = agregarUsuario.contrasena();
        this.perfil = perfil;

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


    public void actualizarUsuario(ActualizarUsuario actualizarUsuario, Perfil perfil) {
        if(actualizarUsuario.contrasena() != null){
            this.contrasena = actualizarUsuario.contrasena();
        }
        if (actualizarUsuario.correoElectronico() != null) {
            this.correoElectronico = actualizarUsuario.correoElectronico();
        }
        if(actualizarUsuario.nombre() != null){
            this.nombre = actualizarUsuario.nombre();
        }
        if(perfil != null){
            this.perfil = perfil;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return correoElectronico;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
