package com.portfolio.Back.Controller;

import com.portfolio.Back.Dto.dtoPys;
import com.portfolio.Back.Entity.Pys;
import com.portfolio.Back.Security.Controller.Mensaje;
import com.portfolio.Back.Security.Service.SPys;
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
@RequestMapping("/pys")
@CrossOrigin(origins = "http://localhost:4200")
public class CPys {

    @Autowired
    public SPys sPys;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lista")
    public ResponseEntity<List<Pys>> list() {
        List<Pys> list = sPys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPys dtopys) {
        if (StringUtils.isBlank(dtopys.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sPys.existsByNombreP(dtopys.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }

        Pys pys = new Pys(dtopys.getNombreP(), dtopys.getDescripcionP(), dtopys.getFetchP(), dtopys.getHerrams(), dtopys.getEnlace());
        sPys.save(pys);

        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPys dtopys) {
        if (!sPys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (sPys.existsByNombreP(dtopys.getNombreP()) && sPys.getByNombreP(dtopys.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopys.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Pys pys = sPys.getOne(id).get();
        pys.setNombreP(dtopys.getNombreP());
        pys.setDescripcionP(dtopys.getDescripcionP());
        pys.setFetchP(dtopys.getFetchP());
        pys.setHerrams(dtopys.getHerrams());
        pys.setEnlace(dtopys.getEnlace());

        sPys.save(pys);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sPys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        sPys.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Pys> getById(@PathVariable("id") int id){
        if(!sPys.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Pys pys = sPys.getOne(id).get();
        return new ResponseEntity(pys, HttpStatus.OK);
    }
}
