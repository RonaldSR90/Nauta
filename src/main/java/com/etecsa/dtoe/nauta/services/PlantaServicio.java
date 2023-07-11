package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.models.entity.ContratosTelef;
import com.etecsa.dtoe.nauta.models.entity.Planta;
import com.etecsa.dtoe.nauta.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaServicio {

    @Autowired
    private PlantaRepository plantaRepository;

    public List<Planta> findAll() {
        return plantaRepository.findAll();
    }

    public void save(Planta planta) {
        plantaRepository.save(planta);
    }

    public Planta get(Long id) {
        return plantaRepository.findById(id).get();
    }

    public void delete(Long id) {
        plantaRepository.deleteById(id);
    }
}
