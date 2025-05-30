package com.perfumelandia.spa.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private int idCategoria;
    private String nombre;
    private String descripcion;


}
