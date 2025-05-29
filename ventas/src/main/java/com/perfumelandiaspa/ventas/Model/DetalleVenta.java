package com.perfumelandiaspa.ventas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DetalleVenta {

    private Long idDetalleVenta;

    private Long idProducto;

    private int cantidad;

    private Double PrecioUnitario;



    

}
