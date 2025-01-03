package com.javh.rest.foro.api_rest_foro.service.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import com.javh.rest.foro.api_rest_foro.domain.curso.CursoRepository;
import com.javh.rest.foro.api_rest_foro.domain.topico.*;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity mostrarTopicosBuscados(Pageable pageable) {
        var topico = topicoRepository.findByActivoTrue(pageable);
        if(topico == null || topico.isEmpty()){
            return ResponseEntity.badRequest().body("Error, no se pudieron obtener los topicos, intenta de nuevo");
        }
        var datosCursos = topico.map(DevolverTopicoSolo::new);

        return ResponseEntity.ok(datosCursos);
    }

    public ResponseEntity mostrarTopicoBuscado(Long id) {
        var topico = topicoRepository.findByIdAndActivoTrue(id).orElse(null);
        if(topico == null || !topico.getActivo()){
            return ResponseEntity.badRequest().body("No hay un topico con el id mencionado");
        }
        var datosTopico = new DevolverTopicoCompleto(topico);
        return ResponseEntity.ok(datosTopico);
    }


    public ResponseEntity agregar(AgregarTopico agregarTopico, UriComponentsBuilder builder) {
        var curso = cursoRepository.findByIdAndActivoTrue(agregarTopico.idCurso()).orElse(null);
        var usuario = usuarioRepository.findByIdAndActivoTrue(agregarTopico.idAutor()).orElse(null);
        if(curso == null || !curso.getActivo() || usuario == null || !usuario.getActivo()){
            return ResponseEntity.badRequest().body("Error, no se encontro el curso o el usuario, verifica los datos e intenta de nuevo");
        }
        var topico = topicoRepository.save(new Topico(agregarTopico, curso,usuario));
        var datosTopico = new DevolverTopicoSolo(topico);
        URI uri= builder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosTopico);
    }
    public ResponseEntity actualizar(Long id, ActualizarTopico actualizarTopico){
        var topico = topicoRepository.findByIdAndActivoTrue(id).orElse(null);
        if(topico == null || !topico.getActivo()){
            return ResponseEntity.badRequest().body("Error, el id del topico no existe en la base de datos");
        }
        topico = topicoRepository.getReferenceById(id);
        if(topico.getAutor().getId() != actualizarTopico.idAutor()){
            return ResponseEntity.badRequest().body("Error, el id del autor del topico enviado no corresponde con el id guardado en la base de datos");
        }
        Curso curso = null;
        if(actualizarTopico.idCurso() != null){
            curso = cursoRepository.findByIdAndActivoTrue(actualizarTopico.idCurso()).orElse(null);
            if(curso == null || !curso.getActivo()){
                return ResponseEntity.badRequest().body("Error, el id del curso no existe en la bd");
            }
        }
        topico.actualizarTopico(actualizarTopico, curso);
        var datosTopico = new DevolverTopicoSolo(topico);
        return ResponseEntity.ok(datosTopico);
    }
}
