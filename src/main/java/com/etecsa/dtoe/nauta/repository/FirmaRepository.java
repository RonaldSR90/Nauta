package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.Firma;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Long> {

    List<Firma> findAll(Sort sort);

    List<String> findByNombre(String nombre);

    List<String> findDistinctNombre();
}