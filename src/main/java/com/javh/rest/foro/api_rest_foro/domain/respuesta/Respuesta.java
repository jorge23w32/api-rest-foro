package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity(name = "Respuesta")
@Table(name = "respuestas")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String solucion;
    //Clases relacionadas
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "autor", nullable = false)
    private Usuario autor;


    //Constructores
    public Respuesta(DatosRespuesta datosRespuesta){
        this.mensaje = datosRespuesta.mensaje();
        this.fechaCreacion = datosRespuesta.fechaCreacion();
        this.solucion = datosRespuesta.solucion();
        this.topico = new Topico(datosRespuesta.topico());
        this.autor = new Usuario(datosRespuesta.autor());
    }
    public Respuesta(){
    }
    public Respuesta(AgregarRespuesta agregarRespuesta, Topico topico, Usuario usuario){
        this.mensaje = agregarRespuesta.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.solucion = agregarRespuesta.solucion();
        this.topico = topico;
        this.autor = usuario;
    }

    //Getters

    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getSolucion() {
        return solucion;
    }

    public Topico getTopico() {
        return topico;
    }

    public Usuario getAutor() {
        return autor;
    }


    public void actualizarUsuario(ActualizarRespuesta actualizarRespuesta) {
        if(actualizarRespuesta.mensaje() != null){
            this.mensaje = actualizarRespuesta.mensaje();
        }
        if(actualizarRespuesta.solucion() != null){
            this.solucion = actualizarRespuesta.solucion();
        }
    }


//    @Override
//    public String toString() {
//        return "Respuesta{" +
//                "id=" + id +
//                ", mensaje='" + mensaje + '\'' +
//                ", fechaCreacion=" + fechaCreacion +
//                ", solucion='" + solucion + '\'' +
//                ", topico=" + topico +
//                ", autor=" + autor +
//                '}';
//    }
}