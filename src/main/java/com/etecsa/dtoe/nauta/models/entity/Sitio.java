package com.etecsa.dtoe.nauta.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "sitio")
public class Sitio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sitio;

    @ManyToOne
    @JoinColumn(name = "plantaId")
    private Planta planta;

    public Sitio() {
    }

    public Sitio(Long id, String sitio, Planta planta) {
        this.id = id;
        this.sitio = sitio;
        this.planta = planta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public Planta getPlanta() {
        return planta;
    }

    public void setPlanta(Planta planta) {
        this.planta = planta;
    }
}
