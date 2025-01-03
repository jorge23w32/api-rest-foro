package com.javh.rest.foro.api_rest_foro.service.curso;

import com.javh.rest.foro.api_rest_foro.domain.curso.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public ResponseEntity mostrarCursosBuscados(Pageable pageable) {
        var cursos = repository.findByActivoTrue(pageable);
        if(cursos == null || cursos.isEmpty()){
            return ResponseEntity.badRequest().body("Error, no se pudieron obtener los cursos, intenta de nuevo");
        }
        var datosCursos = cursos.map(DevolverCursoCompleto::new);

        return ResponseEntity.ok(datosCursos);
    }

    public ResponseEntity mostrarCursoBuscado(Long id) {
        var curso = repository.findByIdAndActivoTrue(id).orElse(null);
        if(curso == null || !curso.getActivo()) {
            return ResponseEntity.badRequest().body("No hay un curso con el id mencionado");
        }
        var datosCurso = new DevolverCursoCompleto(curso);
        return ResponseEntity.ok(datosCurso);
    }

    public ResponseEntity agregar(AgregarCurso agregarCurso, UriComponentsBuilder builder){
      var curso =repository.save(new Curso(agregarCurso));
      var datosCurso = new DevolverCursoSolo(curso);
        URI uri = builder.path("/curso/{id}").buildAndExpand(datosCurso.id()).toUri();
      return ResponseEntity.created(uri).body(datosCurso);
    }

    public ResponseEntity actualizar( Long id, ActualizarCurso actualizarCurso){
        var curso = repository.findByIdAndActivoTrue(id).orElse(null);
        if(curso == null || !curso.getActivo()){
            return ResponseEntity.badRequest().body("Error el id no se encuentra en la base de datos, intenta con otro");
        }
        curso = repository.getReferenceById(id);

        curso.actualizaraCurso(actualizarCurso);
        var datosCurso = new DevolverCursoSolo(curso);
        return ResponseEntity.ok(datosCurso);
    }

}
