package com.perfumelandia.spa.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.perfumelandia.spa.project.Model.Entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    ProductoEntity findByNombre(String nombre);
    ProductoEntity findByIdProducto(int id);
    Boolean existsByNombre(String nombre);
    void deleteByNombre(String nombre);
    List<ProductoEntity> findAll();
    List<ProductoEntity> findByIdCategoria(int categoria);
    List<ProductoEntity> findByIdMarca(int marca);
}
