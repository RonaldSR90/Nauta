package com.etecsa.dtoe.nauta.repository;

import com.etecsa.dtoe.nauta.models.entity.Planta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantaRepository extends JpaRepository<Planta, Long> {
    @Override
    List<Planta> findAll();


}
