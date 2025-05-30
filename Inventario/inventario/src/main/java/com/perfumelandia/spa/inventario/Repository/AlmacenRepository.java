package com.perfumelandia.spa.inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfumelandia.spa.inventario.Model.AlmacenEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface AlmacenRepository extends JpaRepository<AlmacenEntity, Integer>{
    
}
