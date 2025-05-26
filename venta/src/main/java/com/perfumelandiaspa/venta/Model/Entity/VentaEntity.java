package com.perfumelandiaspa.venta.Model.Entity;

import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //se declara como una entidad
@Table(name = "ventas")
@Data
public class VentaEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private Long clienteId;

    @Column(name = "vendedor_id")
    private Long vendedorId;

    @CreationTimestamp //genera la fecha automaticamente al guardar
    @Column(name = "fecha", updatable = false)
    private LocalDateTime fecha; //tipo correcto para JPA

    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetalleVentaEntity> detalles; //= new ArrayList<>();
    
}
