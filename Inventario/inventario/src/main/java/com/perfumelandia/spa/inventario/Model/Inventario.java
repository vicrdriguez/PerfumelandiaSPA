package com.perfumelandia.spa.inventario.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventario {
    private int idInventario;
    private int idProducto;
    private int cantidadDisponible;
    private int cantidadMinima; 
    private String estado;
}
