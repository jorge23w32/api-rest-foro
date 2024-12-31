package com.javh.rest.foro.api_rest_foro.service.topico;

import com.javh.rest.foro.api_rest_foro.domain.curso.CursoRepository;
import com.javh.rest.foro.api_rest_foro.domain.topico.*;
import com.javh.rest.foro.api_rest_foro.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    public ResponseEntity mostrarTopicosBuscados(Pageable pageable) {
        var topicos = topicoRepository.findAllPageable(pageable);
        var datosTopicos = topicos.map(DevolverTopicoCompleto::new);
        return ResponseEntity.ok(datosTopicos);
    }

    public ResponseEntity mostrarTopicoBuscado(Long id) {
        var topico = topicoRepository.findById(id).orElse(null);
        if(topico == null){
            return ResponseEntity.badRequest().body("No hay un topico con el id mencionado");
        }
        var datosTopico = new DevolverTopicoCompleto(topico);
        return ResponseEntity.ok(datosTopico);
    }


    public ResponseEntity agregar(AgregarTopico agregarTopico) {
        var curso = cursoRepository.findById(agregarTopico.idCurso()).orElse(null);
        var usuario = usuarioRepository.findById(agregarTopico.idAutor()).orElse(null);
        if(curso == null || usuario == null){
            return ResponseEntity.badRequest().body("Error, no se encontro el curso o el usuario, verifica los datos e intenta de nuevo");
        }
        var topico = topicoRepository.save(new Topico(agregarTopico, curso,usuario));
        var datosTopico = new DevolverTopicoSolo(topico);
        return ResponseEntity.ok(datosTopico);
    }
}
