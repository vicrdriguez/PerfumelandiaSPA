package com.perfumelandia.spa.inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfumelandia.spa.inventario.Model.InventarioEntity;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioEntity, Integer>{
    InventarioEntity findByIdInventario(int id);
    

    
}
