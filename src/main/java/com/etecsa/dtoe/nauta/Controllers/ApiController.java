package com.etecsa.dtoe.nauta.Controllers;

import com.etecsa.dtoe.nauta.models.entity.Sitio;
import com.etecsa.dtoe.nauta.services.SitioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final SitioService sitioService;

    public ApiController(SitioService sitioService){
        this.sitioService = sitioService;
    }
    @GetMapping("/sitios")
    public List<Sitio> findByPlantaId(@RequestParam("plantaId") Long plantaId){
        return  sitioService.findByPlantaId(plantaId);
    }
}
