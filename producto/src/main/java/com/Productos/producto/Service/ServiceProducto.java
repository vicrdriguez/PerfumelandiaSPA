package com.Productos.producto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Productos.producto.Repository.*;
import com.Productos.producto.Model.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceProducto {
    
    @Autowired
    private ProductoRepository productoRepository;

    public Producto findByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }
}

