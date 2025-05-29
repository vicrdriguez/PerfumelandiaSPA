package com.perfumelandiaspa.ventas.Controller;

import com.perfumelandiaspa.ventas.Model.Venta;
import com.perfumelandiaspa.ventas.Service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaservice;

    @PostMapping
    public ResponseEntity<String> crearVenta(@RequestBody Venta venta){
         return ResponseEntity.ok(ventaservice.crearVenta(venta));
    }




    


}
