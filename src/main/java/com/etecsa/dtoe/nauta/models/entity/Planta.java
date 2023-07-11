package com.etecsa.dtoe.nauta.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "planta")
public class Planta implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String planta;

    @OneToMany
    @JoinColumn(name = "plantaId")
    private List<Sitio> sitios;

    public Planta() {
    }

    public Planta(Long id, String planta, List<Sitio> sitios) {
        this.id = id;
        this.planta = planta;
        this.sitios = sitios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public List<Sitio> getSitios() {
        return sitios;
    }

    public void setSitios(List<Sitio> sitios) {
        this.sitios = sitios;
    }
}
