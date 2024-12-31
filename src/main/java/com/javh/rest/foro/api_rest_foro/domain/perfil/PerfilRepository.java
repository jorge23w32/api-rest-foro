package com.javh.rest.foro.api_rest_foro.domain.perfil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    @Query("select p from Perfil p")
    Page<Perfil> findAllPageable(Pageable pageable);
}
