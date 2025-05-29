package com.perfumelandiaspa.ventas.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "DetalleVenta")
@Entity
@Data
public class DetalleVentaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;

    @Column(name = "IdProducto")
    private Long idProducto;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "PrecioUnitario")
    private Double precioUnitario;
}

