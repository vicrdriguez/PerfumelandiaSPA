package com.perfumelandiaspa.clientes.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.clientes.Model.Cliente;
import com.perfumelandiaspa.clientes.Model.Entity.ClienteEntity;
import com.perfumelandiaspa.clientes.Service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/CrearCliente")
    public ResponseEntity<String> CrearCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.crearCliente(cliente));
    }
    


    @GetMapping("/listarClientes")
    public ResponseEntity<List<ClienteEntity>> listarClientes() {
        List<ClienteEntity> clientes = clienteService.findAll();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/eliminarPorId/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
    try {
        String resultado = clienteService.eliminarPorId(id);
        if (resultado.equals("No existe un cliente con el ID proporcionado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Error del servidor: " + e.getMessage());
    }
}

    @PutMapping("/actualizarCliente/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
    try {
        String resultado = clienteService.actualizarCliente(id, cliente);
        if (resultado.equals("No existe un cliente con el ID proporcionado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Error al actualizar cliente: " + e.getMessage());
    }
}

    
}

