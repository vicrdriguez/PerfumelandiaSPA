package com.perfumelandiaspa.venta.Repository;

import com.perfumelandiaspa.venta.Model.Entity.VentaEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<VentaEntity, Long> {
    // ¡NADA MÁS! No declares métodos que ya existen.
    List<VentaEntity> findByClienteId(Long clienteId);
}
