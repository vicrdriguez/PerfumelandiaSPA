package com.Productos.producto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Productos.producto.Model.Producto;
import com.Productos.producto.Service.ServiceProducto;

@RestController
@RequestMapping("/producto/v1/productos")
public class ProductoController {

    @Autowired
    private ServiceProducto serviceProducto;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> producto = serviceProducto.findAll();
        if (producto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(producto);
    }
    
}
