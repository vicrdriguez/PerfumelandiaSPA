package com.perfumelandiaspa.ventas.Controller;

import com.perfumelandiaspa.ventas.Model.Boleta;

import com.perfumelandiaspa.ventas.Model.VentaRequest;
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

    @PostMapping("/crearBoleta")
    public ResponseEntity<Boleta> crearBoleta(@RequestBody VentaRequest ventaRequest){

        return ResponseEntity.ok(ventaservice.generarBoleta(ventaRequest));

         
    }

    // @GetMapping("/listar")
    // public ResponseEntity<List<Boleta>> listarBoletas(){
    //     return ResponseEntity.ok(ventaservice.listarBoletas());
    // }




    


}
