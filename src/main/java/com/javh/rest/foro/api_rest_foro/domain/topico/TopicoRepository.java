package com.javh.rest.foro.api_rest_foro.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAll(Pageable pageable);

    Optional<Topico> findById(Long id);

    boolean existsByMensaje(String mensaje);

    boolean existsByTitulo(String titulo);
}
