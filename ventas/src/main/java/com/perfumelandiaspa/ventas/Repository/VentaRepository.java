package com.perfumelandiaspa.ventas.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.perfumelandiaspa.ventas.Model.Entity.VentaEntity;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Integer>{

    
    

}
