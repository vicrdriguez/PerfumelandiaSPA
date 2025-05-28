package com.perfumelandiaspa.venta.Model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Venta {
    private Long idVenta;
    private Long idCliente; //usamos estos nombres en Postman
    private Long idVendedor;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") //su formato
    private LocalDateTime fechaVenta; //muestra la hora actual
    private Double totalVenta;
    private List<DetalleVenta> detalles;
}
