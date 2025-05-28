package com.Envios.envio.Envios.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Envios.envio.Envios.Model.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio,Long>{
    
}
