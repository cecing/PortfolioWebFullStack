package com.portfolio.Back.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1, max=20, message="No cumple con la cantidad de caracteres requeridos")
    private String nombre;
    
    @NotNull
    @Size(min=1, max=20, message="No cumple con la cantidad de caracteres requeridos")
    private String apellido;
    
    @Size(min=1, max=20, message="No cumple con la cantidad de caracteres requeridos")
    private String img;
    
    public Persona(){
    }

    public Persona(Long id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
