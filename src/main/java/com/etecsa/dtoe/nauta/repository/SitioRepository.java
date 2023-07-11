package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.Sitio;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SitioRepository extends JpaRepository<Sitio, Long> {
    @Override
    List<Sitio> findAll();

    List<Sitio> findByPlantaId(@Param("plantaId") Long plantaId);
}
