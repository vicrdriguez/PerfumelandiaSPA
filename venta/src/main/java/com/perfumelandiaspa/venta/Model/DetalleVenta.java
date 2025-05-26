package com.perfumelandiaspa.venta.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVenta {
    private Long idProducto; //nombre claro para Postman
    private Integer cantidad;
    private Double precioUnitario;
}
