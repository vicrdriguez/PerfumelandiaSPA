package com.Productos.producto.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Productos.producto.Model.Producto;;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    @Query(value = "SELECT * FROM producto WHERE nombre = :nombre", nativeQuery = true)
    public Producto findByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM producto", nativeQuery = true)
    public List<Producto> findAll();
}
