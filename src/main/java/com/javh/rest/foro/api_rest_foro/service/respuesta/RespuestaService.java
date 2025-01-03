package com.javh.rest.foro.api_rest_foro.service.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.respuesta.*;
import com.javh.rest.foro.api_rest_foro.domain.topico.TopicoRepository;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RespuestaService {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;


    public ResponseEntity mostrarRespuestasBuscadas(Pageable pageable) {
        var respuestas = respuestaRepository.findByActivoTrue(pageable);
        var datosRespuestas = respuestas.map(DevolverRespuestaCompleta::new);
        return ResponseEntity.ok(datosRespuestas);
    }

    public ResponseEntity mostrarRespuestaBuscada(Long id) {
        var respuesta = respuestaRepository.findByIdAndActivoTrue(id).orElse(null);
        if(respuesta == null || !respuesta.getActivo()){
            return ResponseEntity.badRequest().body("No hay una respuesta con ese id");
        }
        var datosRespuesta = new DevolverRespuestaCompleta(respuesta);
        return ResponseEntity.ok(datosRespuesta);
    }

    public ResponseEntity agregar(AgregarRespuesta agregarRespuesta, UriComponentsBuilder builder){
        var autor = usuarioRepository.findByIdAndActivoTrue(agregarRespuesta.autor()).orElse(null);
        var topico = topicoRepository.findByIdAndActivoTrue(agregarRespuesta.topico()).orElse(null);
        if(autor ==null || !autor.getActivo() || topico == null || !topico.getActivo()){
            return ResponseEntity.badRequest().body("Error, no se encontro el autor o el topico en la bd, verifica e intenta de nuevo");
        }
        var respuesta = respuestaRepository.save(new Respuesta(agregarRespuesta, topico, autor));
        var datosrespuesta = new DevolverRespuestaSola(respuesta);
        URI uri = builder.path("/respuesta/{id}").buildAndExpand(respuesta.getId()).toUri();
        return ResponseEntity.created(uri).body(datosrespuesta);
    }

    public ResponseEntity actualizar(Long id,ActualizarRespuesta actualizarRespuesta){
        var respuesta = respuestaRepository.findByIdAndActivoTrue(id).orElse(null);
        if(respuesta == null || !respuesta.getActivo()){
            return ResponseEntity.badRequest().body("Error, el id de la respuesta no existe en la base de datos");
        }

        respuesta = respuestaRepository.getReferenceById(id);

        if(respuesta.getAutor().getId() != actualizarRespuesta.idAutor()){
            return  ResponseEntity.badRequest().body("Error, el usuario o autor enviado no corresponde con autor de la respuesta");
        }
        respuesta.actualizarUsuario(actualizarRespuesta);
        var respuestaDatos = new DevolverRespuestaSola(respuesta);
        return ResponseEntity.ok(respuestaDatos);
    }
}
