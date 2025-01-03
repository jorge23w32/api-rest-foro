package com.javh.rest.foro.api_rest_foro.domain.curso;

import com.javh.rest.foro.api_rest_foro.domain.perfil.Perfil;
import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "Curso")
@Table(name = "cursos")
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
    @OneToMany(mappedBy = "curso", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Topico> topicos;

    private Boolean activo;

    //Constructores
    public Curso(DatosCurso datosCurso){
        this.nombre = datosCurso.nombre();
        this.categoria = datosCurso.categoria();
        this.topicos = datosCurso.topicos().stream().map(Topico::new).toList();
        this.activo = true;
    }
    public Curso(AgregarCurso agregarCurso){
        this.nombre = agregarCurso.nombre();
        this.categoria = agregarCurso.categoria();
        this.activo = true;
    }
    public Curso(){

    }

    //Getters


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void actualizaraCurso(ActualizarCurso actualizarCurso) {
        if(actualizarCurso.categoria() != null){
            this.categoria = actualizarCurso.categoria();
        }
        if(actualizarCurso.nombre() != null){
            this.nombre = actualizarCurso.nombre();
        }
    }
}
