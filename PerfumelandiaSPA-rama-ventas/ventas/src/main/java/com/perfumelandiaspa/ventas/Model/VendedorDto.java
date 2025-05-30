package com.perfumelandiaspa.ventas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorDto {

    private int idVendedor;
    private String sucursal;
    private Double metaMensual;

}
