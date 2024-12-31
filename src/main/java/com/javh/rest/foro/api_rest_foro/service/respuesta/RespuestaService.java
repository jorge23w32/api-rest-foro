package com.javh.rest.foro.api_rest_foro.service.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.*;
import com.javh.rest.foro.api_rest_foro.domain.topico.TopicoRepository;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;


    public ResponseEntity mostrarRespuestasBuscadas(Pageable pageable) {
        var respuestas = respuestaRepository.finAllPageable(pageable);
        var datosRespuestas = respuestas.map(DevolverRespuestaCompleta::new);
        return ResponseEntity.ok(datosRespuestas);
    }

    public ResponseEntity mostrarRespuestaBuscada(Long id) {
        var respuesta = respuestaRepository.findById(id).orElse(null);
        if(respuesta == null){
            return ResponseEntity.badRequest().body("No hay una respuesta con ese id");
        }
        var datosRespuesta = new DevolverRespuestaCompleta(respuesta);
        return ResponseEntity.ok(datosRespuesta);
    }

    public ResponseEntity agregar(AgregarRespuesta agregarRespuesta){
        var autor = usuarioRepository.findById(agregarRespuesta.autor()).orElse(null);
        var topico = topicoRepository.findById(agregarRespuesta.topico()).orElse(null);
        if(autor ==null || topico == null){
            return ResponseEntity.badRequest().body("Error, no se encontro el autor o el topico en la bd, verifica e intenta de nuevo");
        }
        var respuesta = respuestaRepository.save(new Respuesta(agregarRespuesta, topico, autor));
        var datosrespuesta = new DevolverRespuestaSola(respuesta);
        return ResponseEntity.ok(datosrespuesta);
    }
}
