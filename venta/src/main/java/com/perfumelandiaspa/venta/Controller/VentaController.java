package com.perfumelandiaspa.venta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.venta.Model.Venta;
import com.perfumelandiaspa.venta.Service.VentaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;





@RestController //el controlador trabaja con un REST
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping //POST /ventas (Crear venta)
    public ResponseEntity<String> crearVenta(@RequestBody Venta venta)
    {
        return ResponseEntity.ok(ventaService.crearVenta(venta));
    }


    // GET /ventas/{id} (Buscar por ID)
    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarVentaPorId(@PathVariable Long id)
    {
        Venta venta = ventaService.buscarVentaPorId(id);
        return venta != null ? ResponseEntity.ok(venta) : ResponseEntity.notFound().build();
    }
    
    // GET /ventas/cliente/{clienteId}
    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<List<Venta>> buscarVentaPorCliente(@PathVariable Long clienteId)
    {
        List<Venta> ventas = ventaService.buscarVentaPorCliente(clienteId);
        return !ventas.isEmpty() ? ResponseEntity.ok(ventas) : ResponseEntity.notFound().build();
    }
    
}
