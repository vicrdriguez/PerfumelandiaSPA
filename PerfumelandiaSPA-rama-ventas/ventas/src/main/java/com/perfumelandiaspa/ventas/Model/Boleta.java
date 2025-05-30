package com.perfumelandiaspa.ventas.Model;



import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boleta {
    
    
    private ClienteDto cliente;
    private VendedorDto vendedor;
    private List<ProductoDTO> productos;
    private double total;
    
}
