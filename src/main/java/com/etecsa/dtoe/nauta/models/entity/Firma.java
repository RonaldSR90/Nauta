package com.etecsa.dtoe.nauta.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "firmas")
public class Firma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_y_apellidos")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "en_funciones")
    private String funcion;

    @Column(name = "letra_firma")
    private String letra;

    @Column(name = "division_territorial")
    private String division;

    public Firma() {
    }

    public Firma(Long id, String nombre, String cargo, String funcion, String letra, String division) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.funcion = funcion;
        this.letra = letra;
        this.division = division;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
