package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.topico.Topico;
import com.javh.rest.foro.api_rest_foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String autor;
    private String solucion;
    //Clases relacionadas
    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}