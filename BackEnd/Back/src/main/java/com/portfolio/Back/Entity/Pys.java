package com.portfolio.Back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pys {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreP;
    
    private String descripcionP;
    
    private String fetchP;
    
    private String herrams;
    
    private String enlace;
    
    //constructores
    public Pys() {
    }

    public Pys(String nombreP, String descripcionP, String fetchP, String herrams, String enlace) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.fetchP = fetchP;
        this.herrams = herrams;
        this.enlace = enlace;
    }
    
    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
