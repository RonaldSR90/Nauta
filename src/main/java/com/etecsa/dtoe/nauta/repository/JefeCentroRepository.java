package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.JefeCentro;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JefeCentroRepository extends JpaRepository<JefeCentro, Long> {

    List<JefeCentro> findAll(Sort sort);

    List<String> findByNombre(String nombre);

//    List<String> findDistinctNombre();
}
