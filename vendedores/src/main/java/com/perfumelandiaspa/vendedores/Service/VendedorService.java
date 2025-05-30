package com.perfumelandiaspa.vendedores.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandiaspa.vendedores.Model.Vendedor;
import com.perfumelandiaspa.vendedores.Model.Entity.VendedorEntity;
import com.perfumelandiaspa.vendedores.Repository.VendedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendedorService {

    @Autowired
    private final VendedorRepository vendedorRepository;

    //Crear Cliente
public String crearVendedor(Vendedor vendedor) {
    try {


        VendedorEntity vendedorNuevo = new VendedorEntity();
        // vendedorNuevo.setIdVendedor(vendedor.getIdVendedor()); // Asigna el ID manual
        vendedorNuevo.setMetaMensual(vendedor.getMetaMensual());
        vendedorNuevo.setSucursal(vendedor.getSucursal());
        
        vendedorRepository.save(vendedorNuevo);
        return "Vendedor creado con éxito";
    } catch (Exception e) {
        return "Error al crear Vendedor: " + e.getMessage();
    }
}

    

    
}
