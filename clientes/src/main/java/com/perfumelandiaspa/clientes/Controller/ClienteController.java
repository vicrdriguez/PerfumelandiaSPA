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
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/clientes")
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

    @DeleteMapping("/eliminarPorId/{idCliente}")
    public ResponseEntity<String> eliminarPorId(@PathVariable int idCliente) {
    try {
        String resultado = clienteService.eliminarPorId(idCliente);
        if (resultado.equals("No existe un cliente con el ID proporcionado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Error del servidor: " + e.getMessage());
    }
}

    @PutMapping("/actualizarCliente/{idCliente}")
    public ResponseEntity<String> actualizarCliente(@PathVariable int idCliente, @RequestBody Cliente cliente) {
    try {
        String resultado = clienteService.actualizarCliente(idCliente, cliente);
        if (resultado.equals("No existe un cliente con el ID proporcionado")) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Error al actualizar cliente: " + e.getMessage());
    }
}

    @GetMapping("/clientesPorID/{idCliente}")
    public ResponseEntity<ClienteEntity> buscarClienteID(@PathVariable Integer idCliente) {
        try {
            ClienteEntity cliente = clienteService.buscarClienteID(idCliente);
            return ResponseEntity.ok(cliente);  
        } catch (Exception e) {
            return ResponseEntity.notFound().build();  
        }
    }

    
}

