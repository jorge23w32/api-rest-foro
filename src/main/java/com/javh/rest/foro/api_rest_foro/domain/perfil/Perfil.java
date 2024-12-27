package com.javh.rest.foro.api_rest_foro.domain.perfil;

import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity(name = "Perfil")
@Table(name = "perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Rol nombre;
//  Clases relacionadas
    @ManyToMany(mappedBy = "perfiles")
    private Set<Usuario> usuarios;
}
