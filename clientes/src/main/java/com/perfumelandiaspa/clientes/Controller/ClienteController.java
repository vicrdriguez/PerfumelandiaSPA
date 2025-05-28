package com.perfumelandiaspa.clientes.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.clientes.Model.Cliente;
import com.perfumelandiaspa.clientes.Model.Entity.ClienteEntity;
import com.perfumelandiaspa.clientes.Service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class ClienteController {
@Autowired
private ClienteService clienteService;

@PostMapping("/Cliente")
//ResponseEntity

public ResponseEntity<ClienteEntity> ObtenerClietne(@RequestBody ClienteEntity cliente){
    return ResponseEntity.ok(clienteService.crearCliente(cliente));
     
}

@GetMapping("/ListarClientes")
    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> producto = ClienteService.findAll();
        if (producto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(producto);
    }





}
