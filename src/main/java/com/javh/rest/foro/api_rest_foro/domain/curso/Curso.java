package com.javh.rest.foro.api_rest_foro.domain.curso;

import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    //Clases relacionadas
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Topico> topicos;
}
