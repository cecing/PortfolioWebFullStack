package com.portfolio.Back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreE;
    
    private String descripcionE;
    
    private String fetchInicio;
    
    private String fetchFin;
    
    //constructores
    public Educacion() {
    }

    public Educacion(String nombreE, String descripcionE, String fetchInicio, String fetchFin) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fetchInicio = fetchInicio;
        this.fetchFin = fetchFin;
    }
    
    //getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getFetchInicio() {
        return fetchInicio;
    }

    public void setFetchInicio(String fetchInicio) {
        this.fetchInicio = fetchInicio;
    }

    public String getFetchFin() {
        return fetchFin;
    }

    public void setFetchFin(String fetchFin) {
        this.fetchFin = fetchFin;
    }
    
}
