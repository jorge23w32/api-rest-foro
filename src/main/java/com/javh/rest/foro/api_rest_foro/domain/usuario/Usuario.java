package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Set;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
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
    @ManyToMany
    @JoinTable(
            name = "usuarios_perfiles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<Perfil> perfiles;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Topico> topicos;
}
