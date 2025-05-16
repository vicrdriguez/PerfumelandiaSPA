package com.Ventas.venta.Ventas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ventas.venta.Ventas.Model.Venta;
import com.Ventas.venta.Ventas.Repository.RepositoryVenta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceVenta {

    //Crear Objeto de clase RepositoryVenta
    @Autowired
    private RepositoryVenta RepositoryVenta;


    //Buscar Todas las ventas
    public List<Venta> findAll(){
        return RepositoryVenta.findAll();
    }

    //Buscar por id De la venta
    public Venta FindById(Long id){
        return RepositoryVenta.FindById(id).get(0);
    }

    //Borrar Venta por id 
    public void delete(Long Id){
        RepositoryVenta.deleteById(Id);
    }


}
