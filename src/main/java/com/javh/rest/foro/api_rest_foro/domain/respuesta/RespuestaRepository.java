package com.javh.rest.foro.api_rest_foro.domain.respuesta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    @Query("select r from  Respuesta  r")
    Page<Respuesta> finAllPageable(Pageable pageable);
}
