package com.perfumelandiaspa.ventas.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaRequest {
    private int idCliente;
    private List<Integer> productos;

}
