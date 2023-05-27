package com.etecsa.dtoe.nauta.models.entity;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "contratostelef")
public class ContratosTelef implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String servicio;

    private String ed;
    private String nombre;
    private String categcli;
    private String tiposerv;
    private String nombpta;
    private String centrotelec;
    private String sitio;
    private String direccion;
    private String oficina_comercial;
    private String cat_cliente;
    private String tcliente;
    private String t_servicio;
    private String solicitado;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_autorizo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_entrada;

    private boolean ofertado;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_alta;

    private String observacion;

    public ContratosTelef() {
    }

    public ContratosTelef(String servicio, String ed, String nombre, String categcli, String tiposerv, String nombpta, String centrotelec, String sitio, String direccion, String oficina_comercial, String cat_cliente, String tcliente, String t_servicio, String solicitado, Date fecha_autorizo, Date fecha_entrada, boolean ofertado, Date fecha_alta, String observacion, char trial615) {
        this.id = id;
        this.servicio = servicio;
        this.ed = ed;
        this.nombre = nombre;
        this.categcli = categcli;
        this.tiposerv = tiposerv;
        this.nombpta = nombpta;
        this.centrotelec = centrotelec;
        this.sitio = sitio;
        this.direccion = direccion;
        this.oficina_comercial = oficina_comercial;
        this.cat_cliente = cat_cliente;
        this.tcliente = tcliente;
        this.t_servicio = t_servicio;
        this.solicitado = solicitado;
        this.fecha_autorizo = fecha_autorizo;
        this.fecha_entrada = fecha_entrada;
        this.ofertado = ofertado;
        this.fecha_alta = fecha_alta;
        this.observacion = observacion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEd() {
        return ed;
    }

    public void setEd(String ed) {
        this.ed = ed;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategcli() {
        return categcli;
    }

    public void setCategcli(String categcli) {
        this.categcli = categcli;
    }

    public String getTiposerv() {
        return tiposerv;
    }

    public void setTiposerv(String tiposerv) {
        this.tiposerv = tiposerv;
    }

    public String getNombpta() {
        return nombpta;
    }

    public void setNombpta(String nombpta) {
        this.nombpta = nombpta;
    }

    public String getCentrotelec() {
        return centrotelec;
    }

    public void setCentrotelec(String centrotelec) {
        this.centrotelec = centrotelec;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOficina_comercial() {
        return oficina_comercial;
    }

    public void setOficina_comercial(String oficina_comercial) {
        this.oficina_comercial = oficina_comercial;
    }

    public String getCat_cliente() {
        return cat_cliente;
    }

    public void setCat_cliente(String cat_cliente) {
        this.cat_cliente = cat_cliente;
    }

    public String getTcliente() {
        return tcliente;
    }

    public void setTcliente(String tcliente) {
        this.tcliente = tcliente;
    }

    public String getT_servicio() {
        return t_servicio;
    }

    public void setT_servicio(String t_servicio) {
        this.t_servicio = t_servicio;
    }

    public String getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(String solicitado) {
        this.solicitado = solicitado;
    }

    public Date getFecha_autorizo() {
        return fecha_autorizo;
    }

    public void setFecha_autorizo(Date fecha_autorizo) {
        this.fecha_autorizo = fecha_autorizo;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public boolean isOfertado() {
        return ofertado;
    }

    public void setOfertado(boolean ofertado) {
        this.ofertado = ofertado;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    private static final long serialVersionUID = 1L;
}
