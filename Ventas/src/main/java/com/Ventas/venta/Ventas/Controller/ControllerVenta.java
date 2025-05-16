package com.Ventas.venta.Ventas.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ventas.venta.Ventas.Model.Venta;
import com.Ventas.venta.Ventas.Service.ServiceVenta;

@RestController
//Mapea la ruta
@RequestMapping("/api/v1")
public class ControllerVenta {

    @Autowired

    private ServiceVenta ServiceVenta;
    
    //Mapea la ruta
    @GetMapping("/Venta")
    public ResponseEntity<List<Venta>> listar(){s
        List<Venta> venta = ServiceVenta.findAll();
        if (venta.isEmpty()) {
            return ResponseEntity.noContent().build();    
        }
        return ResponseEntity.ok(venta);
    }

}
