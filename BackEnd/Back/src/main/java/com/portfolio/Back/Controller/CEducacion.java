package com.portfolio.Back.Controller;

import com.portfolio.Back.Dto.dtoEducacion;
import com.portfolio.Back.Entity.Educacion;
import com.portfolio.Back.Entity.Experiencia;
import com.portfolio.Back.Security.Controller.Mensaje;
import com.portfolio.Back.Security.Service.SEducacion;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    public SEducacion sEducacion;
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoedu.getNombreE(), dtoedu.getDescripcionE(), dtoedu.getFetchFin(), dtoedu.getFetchInicio());
        sEducacion.save(educacion);

        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (sEducacion.existsByNombreE(dtoedu.getNombreE()) && sEducacion.getByNombreE(dtoedu.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoedu.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setNombreE(dtoedu.getNombreE());
        educacion.setDescripcionE(dtoedu.getDescripcionE());
        educacion.setFetchInicio(dtoedu.getFetchInicio());
        educacion.setFetchFin(dtoedu.getFetchFin());

        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sEducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
}
