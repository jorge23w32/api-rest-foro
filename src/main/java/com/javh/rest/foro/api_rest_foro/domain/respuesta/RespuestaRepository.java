package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    Page<Respuesta> findByActivoTrue(Pageable pageable);

    Optional<Respuesta> findByIdAndActivoTrue(Long id);
}
