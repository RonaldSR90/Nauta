package com.etecsa.dtoe.nauta.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "jefes_ctlc")
public class JefeCentro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Column(name = "nombre_jefe_ctlc")
    private String nombre;

    @Column(nullable = false)
    @Column(name = "iniciales_ctlc")
    private String inicial;

    @Column(nullable = false)
    @Column(name = "ctlc")
    private String centro;

    @Column(nullable = false)
    @Column(name = "responsabilidad")
    private String responsabilidad;

    public JefeCentro() {
    }

    public JefeCentro(Long id, String nombre, String inicial, String centro, String responsabilidad) {
        this.id = id;
        this.nombre = nombre;
        this.inicial = inicial;
        this.centro = centro;
        this.responsabilidad = responsabilidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(String responsabilidad) {
        this.responsabilidad = responsabilidad;
    }
}
