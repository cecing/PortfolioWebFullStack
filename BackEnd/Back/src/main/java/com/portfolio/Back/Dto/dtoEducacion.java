package com.portfolio.Back.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreE;
    
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    private String fetchInicio;
    
    @NotBlank
    private String fetchFin;
    
    //cosntructores
    public dtoEducacion() {
    }

    public dtoEducacion(String nombreE, String descripcionE, String fetchInicio, String fetchFin) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fetchInicio = fetchInicio;
        this.fetchFin = fetchFin;
    }
    
    //getters y setters
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
