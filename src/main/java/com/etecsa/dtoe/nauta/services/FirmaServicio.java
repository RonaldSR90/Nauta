package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.models.entity.Firma;
import com.etecsa.dtoe.nauta.repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirmaServicio {

    @Autowired
    private FirmaRepository firmaRepository;

    public List<Firma> listAll(){
        return firmaRepository.findAll();
    }

    public void save (Firma firma) {
        firmaRepository.save(firma);
    }

    public Firma get(Long id){
        return firmaRepository.findById(id).get();
    }

    public void delete(Long id){
        firmaRepository.deleteById(id);
    }

    public List<String> findByNombre(String nombre){
        return firmaRepository.findByNombre(nombre);
    }
/*
    public List<String> findDistinctNombre(){
        return firmaRepository.findDistinctNombre_y_apellidos();
    }

 */
}
