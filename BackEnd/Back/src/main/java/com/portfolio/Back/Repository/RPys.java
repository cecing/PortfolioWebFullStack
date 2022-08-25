package com.portfolio.Back.Repository;

import com.portfolio.Back.Entity.Pys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPys extends JpaRepository<Pys, Integer>{
    public Optional<Pys> findByNombreP(String nombreP);

    public boolean existsByNombreP(String nombreP);
}
