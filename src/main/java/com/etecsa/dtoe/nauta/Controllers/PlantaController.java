package com.etecsa.dtoe.nauta.Controllers;

import com.etecsa.dtoe.nauta.models.entity.Planta;
import com.etecsa.dtoe.nauta.services.PlantaServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PlantaController {
    private final PlantaServicio plantaServicio;

    public PlantaController(PlantaServicio plantaServicio){
        this.plantaServicio = plantaServicio;
    }

    @GetMapping
    public String Lista(Model model){
        List<Planta> planta = plantaServicio.findAll();
        model.addAttribute("planta", planta);
        return "listaplants";
    }

}
