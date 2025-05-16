package com.Envios.envio.Envios.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "envio")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "envio_seq")
    @SequenceGenerator(name = "envio_seq",sequenceName = "ENVIO_SEQ",allocationSize = 1)
    @Column(name = "ID",nullable = false)
    private Long id;

    @Column(name = "venta_id",nullable = false)
    private Long ventaId;

    @Column(name = "estado",length = 50,nullable = false)
    private String estado;
    
    @Column(name = "fecha_envio")
    private Date fechaEnvio;
    
    @Column(name = "transportista",length = 100,nullable = false) 
    private String transportista;
}


