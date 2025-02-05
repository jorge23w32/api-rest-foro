package com.javh.rest.foro.api_rest_foro.domain.usuario;

import com.javh.rest.foro.api_rest_foro.domain.curso.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAll(Pageable pageable);

    Optional<Usuario> findById(Long id);

    UserDetails findByCorreoElectronico(String correo);
}
