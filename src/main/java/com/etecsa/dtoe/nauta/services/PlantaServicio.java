package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantaServicio {

    @Autowired
    private PlantaRepository plantaRepository;
}
