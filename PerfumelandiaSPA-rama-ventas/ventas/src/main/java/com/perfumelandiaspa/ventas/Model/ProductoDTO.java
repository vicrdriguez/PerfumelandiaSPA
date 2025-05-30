package com.perfumelandiaspa.ventas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private int idProducto;
    private String nombre;
    private int cantidad;
    private float precio;
}
