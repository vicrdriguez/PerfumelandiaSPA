package com.perfumelandiaspa.vendedores.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.perfumelandiaspa.vendedores.Model.Vendedor;
import com.perfumelandiaspa.vendedores.Model.Entity.VendedorEntity;
import com.perfumelandiaspa.vendedores.Repository.VendedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VendedorService {
    private final VendedorRepository vendedorRepository;

    //Convertir Entity a DTO
    private Vendedor toDto(VendedorEntity entity)
    {
        return new Vendedor(
            entity.getId(),
            entity.getSucursal(),
            entity.getMetaMensual()
        );
    }

    //Crear vendedor
    public Vendedor crearVendedor(Vendedor vendedorRequest)
    {
        VendedorEntity entidad = new VendedorEntity();
        entidad.setSucursal(vendedorRequest.getSucursal());
        entidad.setMetaMensual(vendedorRequest.getMetaMensual());

        VendedorEntity savedEntity = vendedorRepository.save(entidad);
        return toDto(savedEntity);
    }

    //Buscar por ID
    public Vendedor buscarPorId(Long Id)
    {
        return vendedorRepository.findById(Id).map(this::toDto).orElse(null);
    }

    //Buscar por sucursal
    public List<Vendedor> buscarPorSucursal(String sucursal)
    {
        return vendedorRepository.findBySucursal(sucursal).stream().map(this::toDto).collect(Collectors.toList());
    }

    
}
