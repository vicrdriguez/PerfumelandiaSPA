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

    private ClienteRepository clienteRepository; //Instancia de cliente repository


    //Metodo para Crear Clientes en la base de datos
    public String crearCliente(Cliente cliente) {
        try {
            if (clienteRepository.existsByRut(cliente.getRut())) { // En caso de que ya exista el rut retornara un mensaje de error para que el sistema no se caiga
                return "Este cliente ya tiene asociado su RUT";
            }

            ClienteEntity clienteNuevo = new ClienteEntity(); // Crea una nueva instancia que copia los datos del objeto cliente para guardarlo en la base de datos
            clienteNuevo.setRut(cliente.getRut());
            clienteNuevo.setNombre(cliente.getNombre());
            clienteNuevo.setApellido(cliente.getApellido());
            clienteNuevo.setDireccion(cliente.getDireccion());
            clienteNuevo.setTelefono(cliente.getTelefono());

            
            clienteRepository.save(clienteNuevo); // Guarda  la instancia nueva  en la base de datos utilizando la instancia repositorio
            return "Cliente creado con éxito";
        } catch (Exception e) {
            return "Error al crear cliente: " + e.getMessage();
        }
    }

    //Metodo para listar todos los clientes
    public List<ClienteEntity> findAll() { // Lista todos los  clientes ya ingresados a la base de datos utilizando la instancia repositorio
        return clienteRepository.findAll();
    }


    //Metodo para Eliminar cliente por id
    public String eliminarPorId(int idCliente) {

        //En caso de error
        try {
            if (!clienteRepository.existsById(idCliente)) { //Validacion en caso de no existir ningun cliente con id Proporcionada retornando un mensaje de error
                return "No existe un cliente con el Id proporcionado";
            }
            
            clienteRepository.deleteById(idCliente); // Elimina al objeto buscado por la id utilizando metodos de la instancia repositorio
            return "Cliente eliminado correctamente";
        } catch (Exception e) {
            return "Error al eliminar cliente: " + e.getMessage();
        }
    }


    // Método para actualizar cliente por ID 
    public String actualizarCliente(int idCliente, Cliente cliente) {
    try {

        
        ClienteEntity clienteExistente = clienteRepository.findById(idCliente) // Busca un cliente por id Existente en caso de no encontrar  tirar un mensaje de expection
            .orElseThrow(() -> new RuntimeException("No existe un cliente con el ID proporcionado"));
        
        // Actualizar todos los campos directamente
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        
        // Guardar los cambios
        clienteRepository.save(clienteExistente);
        
        return "Cliente actualizado con éxito";
    } catch (RuntimeException e) {
        return e.getMessage();
    } catch (Exception e) {
        return "Error al actualizar cliente: " + e.getMessage();
    }
}

    //Metodo para buscar cliente por id
    public ClienteEntity buscarClienteID(int idCliente){
        return clienteRepository.findById(idCliente).get();
    }

}