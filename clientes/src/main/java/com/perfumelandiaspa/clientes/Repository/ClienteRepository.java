package com.perfumelandiaspa.clientes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfumelandiaspa.clientes.Model.Entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {


    String existsByRut(ClienteEntity clienteEntity)


    
}
