package com.perfumelandiaspa.ventas.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private int idCliente;
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
}
