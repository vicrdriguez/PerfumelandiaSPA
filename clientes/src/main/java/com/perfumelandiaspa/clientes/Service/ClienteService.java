package com.perfumelandiaspa.clientes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandiaspa.clientes.Model.Cliente;
import com.perfumelandiaspa.clientes.Model.Entity.ClienteEntity;
import com.perfumelandiaspa.clientes.Repository.ClienteRepository;



@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    //metodo Crear cliente

    public String crearCliente(Cliente cliente){

        try {

            //Detecto si el cliente ya existe en la base de datos
            Boolean estado = clienteRepository.ExistePorRut(cliente.getRut());
            if (!estado) {

                ClienteEntity clienteNuevo = new ClienteEntity();
                clienteNuevo.setRut(cliente.getRut());
                clienteNuevo.setNombre(cliente.getNombre());
                clienteNuevo.setApellido(cliente.getApellido());
                clienteNuevo.setDireccion(cliente.getDireccion());
                clienteNuevo.setTelefono(cliente.getTelefono());

                // se inserta una nueva fila a la tabla Cliente en la base de datos
                clienteRepository.save(clienteNuevo);
                return "Clietne creado con exito";
   
            }
            else{
                return "Este cliente ya tiene asociado su rut";
            }
             
            } 
        catch (Exception e) {
            return "Error al crear Cliente nnuevo";
        }
    }



    


    //metodo para listar todos los clientes existentes usando Metodo FindByAll
    public List<ClienteEntity> findAll(){
        return clienteRepository.findAll();
    }



    


}
