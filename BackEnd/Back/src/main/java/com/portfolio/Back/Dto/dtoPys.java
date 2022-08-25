package com.portfolio.Back.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPys {
    @NotBlank
    private String nombreP;
    
    @NotBlank
    private String descripcionP;
    
    @NotBlank
    private String fetchP;
    
    @NotBlank
    private String herrams;
    
    @NotBlank
    private String enlace;
    
     //cosntructores
    public dtoPys() {
    }

    public dtoPys(String nombreP, String descripcionP, String fetchP, String herrams, String enlace) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.fetchP = fetchP;
        this.herrams = herrams;
        this.enlace = enlace;
    }
    
    //getters y setters

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getFetchP() {
        return fetchP;
    }

    public void setFetchP(String fetchP) {
        this.fetchP = fetchP;
    }

    public String getHerrams() {
        return herrams;
    }

    public void setHerrams(String herrams) {
        this.herrams = herrams;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    
}
