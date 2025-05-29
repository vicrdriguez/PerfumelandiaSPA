package com.perfumelandiaspa.clientes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    private Long id;

    private String rut;

    private String nombre;

    private String apellido;

    private String direccion;

    private int telefono;

    private Long id_usuario;

    
    


}
