package com.perfumelandia.spa.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private int idMarca;
    private int idCategoria;


}
