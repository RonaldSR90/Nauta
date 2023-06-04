package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.models.entity.JefeCentro;
import com.etecsa.dtoe.nauta.repository.JefeCentroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JefeCentroServicio {

    @Autowired
    private JefeCentroRepository jefeCentroRepository;

    public List<JefeCentro> listAll(){
        return jefeCentroRepository.findAll();
    }

    public void save(JefeCentro jefeCentro){
        jefeCentroRepository.save(jefeCentro);
    }

    public JefeCentro get(Long id){
        return jefeCentroRepository.findById(id).get();
    }

    public void delete(Long id){
        jefeCentroRepository.deleteById(id);
    }

    public List<String> findByNombre(String nombre){
        return jefeCentroRepository.findByNombre(nombre);
    }
/*
    public List<String> findDistinctNombre(){
        return jefeCentroRepository.findDistinctNombre();
    }

 */
}
