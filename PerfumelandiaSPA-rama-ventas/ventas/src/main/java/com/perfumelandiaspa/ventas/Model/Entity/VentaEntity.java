package com.perfumelandiaspa.ventas.Model.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="Venta")
@Entity
@Data
public class VentaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;


    

    @Column(name = "FechaVenta")
    private LocalDateTime fechaVenta;

    

}
