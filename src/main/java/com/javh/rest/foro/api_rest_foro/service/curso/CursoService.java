package com.javh.rest.foro.api_rest_foro.service.curso;

import com.javh.rest.foro.api_rest_foro.domain.curso.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    public ResponseEntity mostrarCursosBuscados(Pageable pageable) {
        var cursos = repository.findAllPegable(pageable);
        if(cursos == null || cursos.isEmpty()){
            return ResponseEntity.badRequest().body("Error, no se pudieron obtener los cursos, intenta de nuevo");
        }
        var datosCursos = cursos.map(DevolverCursoCompleto::new);
        return ResponseEntity.ok(datosCursos);
    }

    public ResponseEntity mostrarCursoBuscado(Long id) {
        var curso = repository.findById(id).orElse(null);
        if(curso == null){
            return ResponseEntity.badRequest().body("No hay un curso con el id mencionado");
        }
        var datosCurso = new DevolverCursoCompleto(curso);
        return ResponseEntity.ok(datosCurso);
    }

    public ResponseEntity agregar(AgregarCurso agregarCurso){
      var curso =repository.save(new Curso(agregarCurso));
      var datosCurso = new DevolverCursoSolo(curso);
      return ResponseEntity.ok(datosCurso);
    }


}
