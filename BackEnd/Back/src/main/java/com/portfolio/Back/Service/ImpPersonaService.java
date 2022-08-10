package com.portfolio.Back.Service;

import com.portfolio.Back.Entity.Persona;
import com.portfolio.Back.Interface.IPersonaService;
import com.portfolio.Back.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired 
    public IPersonaRepository IPersonaRepository;
            
    @Override
    public List<Persona> getPersona() {
        return IPersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        IPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        IPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return IPersonaRepository.findById(id).orElse(null);
    }
    
}
