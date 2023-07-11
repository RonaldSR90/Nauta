package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
}
