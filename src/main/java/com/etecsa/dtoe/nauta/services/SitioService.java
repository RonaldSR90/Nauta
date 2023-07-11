package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.models.entity.ContratosTelef;
import com.etecsa.dtoe.nauta.models.entity.Sitio;
import com.etecsa.dtoe.nauta.repository.SitioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SitioService {

    @Autowired
    private SitioRepository sitioRepository;

    public List<Sitio> findAll() {
        return sitioRepository.findAll();
    }

    public List<Sitio> findByPlantaId(Long plantaId){
        return sitioRepository.findByPlantaId(plantaId);
    }

    public void save(Sitio sitio) {
        sitioRepository.save(sitio);
    }

    public Sitio get(Long id) {
        return sitioRepository.findById(id).get();
    }

    public void delete(Long id) {
        sitioRepository.deleteById(id);
    }
}
