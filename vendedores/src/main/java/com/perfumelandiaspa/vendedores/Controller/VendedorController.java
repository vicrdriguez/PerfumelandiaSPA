package com.perfumelandiaspa.vendedores.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.vendedores.Model.Vendedor;
import com.perfumelandiaspa.vendedores.Service.VendedorService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController //el controlador trabaja con un REST
@RequestMapping("/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;

    @PostMapping
    public ResponseEntity<Vendedor> crearVendedor(@RequestBody Vendedor vendedor)
    {
        return ResponseEntity.ok(vendedorService.crearVendedor(vendedor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarPorId(@PathVariable Long id)
    {
        Vendedor vendedor = vendedorService.buscarPorId(id);
        return vendedor != null ? ResponseEntity.ok(vendedor) : ResponseEntity.notFound().build();
    }

    @GetMapping("/sucursal/{nombre}")
    public ResponseEntity<List<Vendedor>> buscarPorSucursal(@PathVariable String nombre)
    {
        return ResponseEntity.ok(vendedorService.buscarPorSucursal(nombre));
    }
    
}
