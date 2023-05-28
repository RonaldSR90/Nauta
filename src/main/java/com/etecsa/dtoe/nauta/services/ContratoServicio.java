package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.models.entity.ContratosTelef;
import com.etecsa.dtoe.nauta.repository.ContratosTelefRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ContratoServicio {

    @Autowired
    private ContratosTelefRepository contratosTelefRepository;

    public List<ContratosTelef> listAll() {
        return contratosTelefRepository.findAll();
    }

    public Page<ContratosTelef> findAll(Pageable pageable) {
        return contratosTelefRepository.findAll(pageable);
    }

    public void save(ContratosTelef contratosTelef) {
        contratosTelefRepository.save(contratosTelef);
    }

    public ContratosTelef get(Long id) {
        return contratosTelefRepository.findById(id).get();
    }

    public void delete(Long id) {
        contratosTelefRepository.deleteById(id);
    }

    public ContratosTelef findByServicio(String servicio) {
        return contratosTelefRepository.findByServicio(servicio);
    }

    public ContratosTelef findBySolicitado(String solicitado) {
        return contratosTelefRepository.findBySolicitado(solicitado);
    }

    public Page<ContratosTelef> findBySolicitado(String solcitado, Pageable pageable){
        return contratosTelefRepository.findBySolicitado(solcitado, pageable);
    }

    public Page<ContratosTelef> findBySolicitadoIsNotNull(Pageable pageable){
        return contratosTelefRepository.findBySolicitadoIsNotNull(pageable);
    }

    public Page<ContratosTelef> findByServicio(String servicio, Pageable pageable){
        return contratosTelefRepository.findByServicio(servicio, pageable);
    }

    public Page<ContratosTelef> findByPlantaSitio(String nombpta, String sitio, Pageable pageable){
        return contratosTelefRepository.findByPlantaSitio(nombpta, sitio, pageable);
    }

    // Para hacer la lista en solicitado por
    public List<String> findDistinctSolicitado(){
        return contratosTelefRepository.findDistinctSolicitado();
    }

}
