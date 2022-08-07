package com.portfolio.Back.Interface;

import com.portfolio.Back.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //traer 1 lista de Personas
    public List<Persona> getPersona();
    
    //guarda 1 Obj. de tipo Persona
    public void savePersona(Persona persona);
    
    //eliminar 1 Obj. Persona según id que paso
    public void deletePersona(Long id);
    
    //buscar 1 Persona por id
    public Persona findPersona(Long id);
    
}
