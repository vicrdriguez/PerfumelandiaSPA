package com.perfumelandia.spa.inventario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandia.spa.inventario.Model.Almacen;
import com.perfumelandia.spa.inventario.Service.AlmacenService;

@RestController
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;
    
    @PostMapping("/almacen/crear")
    public ResponseEntity<String> crearAlmacen(@RequestBody Almacen almacen){
        return ResponseEntity.ok(almacenService.crearAlmacen(almacen));
    }
}
