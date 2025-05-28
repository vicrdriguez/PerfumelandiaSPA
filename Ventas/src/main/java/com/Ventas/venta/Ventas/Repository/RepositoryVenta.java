package com.Ventas.venta.Ventas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ventas.venta.Ventas.Model.Venta;

@Repository
public interface RepositoryVenta extends JpaRepository<Venta,Long> {



    //Consulta para encuentra Venta por id 
    @Query(value = "SELECT * FROM venta WHERE id= :id",nativeQuery = true)
    List<Venta>FindById(Long id);

    //Consulta para buscar toda las ventas 
    @Query(value = "SELECT * FROM venta",nativeQuery = true)
    List<Venta>findAll();
    
}
