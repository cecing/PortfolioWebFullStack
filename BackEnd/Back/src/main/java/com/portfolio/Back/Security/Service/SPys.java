package com.portfolio.Back.Security.Service;

import com.portfolio.Back.Entity.Pys;
import com.portfolio.Back.Repository.RPys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPys {
    @Autowired
    RPys rPys;
    
    public List<Pys> list() {
        return rPys.findAll();
    }

    public Optional<Pys> getOne(int id) {
        return rPys.findById(id);
    }

    public Optional<Pys> getByNombreP(String nombreP) {
        return rPys.findByNombreP(nombreP);
    }

    public void save(Pys pys) {
        rPys.save(pys);
    }

    public void delete(int id) {
        rPys.deleteById(id);
    }

    public boolean existsById(int id) {
        return rPys.existsById(id);
    }

    public boolean existsByNombreP(String nombreP) {
        return rPys.existsByNombreP(nombreP);
    }

}
