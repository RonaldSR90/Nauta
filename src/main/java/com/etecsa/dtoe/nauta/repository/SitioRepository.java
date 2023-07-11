package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.Sitio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitioRepository extends JpaRepository<Sitio, Long> {
}
