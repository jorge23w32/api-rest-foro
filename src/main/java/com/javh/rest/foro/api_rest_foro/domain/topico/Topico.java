package com.javh.rest.foro.api_rest_foro.domain.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import com.javh.rest.foro.api_rest_foro.domain.respuesta.Respuesta;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
//  Clases Relacionadas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor", nullable = false)
    private Usuario autor;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    public Topico(DatosTopico datosTopico){
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = datosTopico.fechaCreacion();
        this.status = true;
        this.curso = new Curso(datosTopico.curso());
        this.autor = new Usuario(datosTopico.autor());
        this.respuestas = datosTopico.respuestas().stream().map(Respuesta::new).toList();
    }
    public Topico(AgregarTopico datosTopico, Curso curso, Usuario autor){
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = true;
        this.curso = curso;
        this.autor = autor;
    }
    public Topico(){
    }


    //Getters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public Curso getCurso() {
        return curso;
    }

    public Usuario getAutor() {
        return autor;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }


    public void actualizarTopico(ActualizarTopico actualizarTopico, Curso curso) {
        if(actualizarTopico.mensaje() != null){
            this.mensaje = actualizarTopico.mensaje();
        }
        if(actualizarTopico.titulo() != null){
            this.titulo = actualizarTopico.titulo();
        }
        if(actualizarTopico.status() != null){
            this.status = actualizarTopico.status();
        }
        if(curso != null){
            this.curso = curso;
        }
    }


//
//    @Override
//    public String toString() {
//        return "Topico{" +
//                "id=" + id +
//                ", titulo='" + titulo + '\'' +
//                ", mensaje='" + mensaje + '\'' +
//                ", fechaCreacion=" + fechaCreacion +
//                ", status=" + status +
//                ", curso=" + curso +
//                ", autor=" + autor +
//                ", respuestas=" + respuestas +
//                '}';
//    }
}
