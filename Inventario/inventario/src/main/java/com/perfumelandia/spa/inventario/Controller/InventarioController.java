package com.perfumelandia.spa.inventario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandia.spa.inventario.Model.Inventario;
import com.perfumelandia.spa.inventario.Service.InventarioService;

@RestController
public class InventarioController {
    @Autowired
    private InventarioService inventarioService;

    @GetMapping("inventario/{id}")
    public ResponseEntity<Inventario> obtenerInventario(@PathVariable int id){
        Inventario inventario = inventarioService.obtenerInventario(id);
        if (inventario != null) {
            return ResponseEntity.ok(inventario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("inventario/crearInventario")
    public ResponseEntity<String> crearInventario(@RequestBody Inventario inv){
        return ResponseEntity.ok(inventarioService.crearInventario(inv));
    }

   

}
