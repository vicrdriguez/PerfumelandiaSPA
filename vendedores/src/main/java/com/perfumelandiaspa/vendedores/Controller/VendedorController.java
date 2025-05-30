package com.perfumelandiaspa.vendedores.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.vendedores.Model.Vendedor;
import com.perfumelandiaspa.vendedores.Service.VendedorService;

import lombok.RequiredArgsConstructor;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController //el controlador trabaja con un REST
@RequestMapping("/crearVendedor")
@RequiredArgsConstructor
public class VendedorController {
    @Autowired
    private VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<String> crearVendedor(@RequestBody Vendedor vendedor) {
        String resultado = vendedorService.crearVendedor(vendedor);
        
        if (resultado.startsWith("Error")) {
            return ResponseEntity.badRequest().body(resultado); // HTTP 400 si hay error
        } else {
            return ResponseEntity.ok(resultado); // HTTP 200 si es exitoso
        }
    }
    
}
