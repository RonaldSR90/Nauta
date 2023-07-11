package com.etecsa.dtoe.nauta.services;

import com.etecsa.dtoe.nauta.repository.SitioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SitioService {

    @Autowired
    private SitioRepository sitioRepository;
}
