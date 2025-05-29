package com.perfumelandiaspa.vendedores.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {
    private Long id;
    private String sucursal;
    private Double metaMensual;
    //usuarioId creo q no va

}
