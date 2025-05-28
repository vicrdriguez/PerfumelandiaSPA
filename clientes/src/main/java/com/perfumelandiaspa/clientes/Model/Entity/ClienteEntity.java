package com.perfumelandiaspa.clientes.Model.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@EntityScan
@Data

public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



    @Column(name="rut_cliente",nullable = false)
    private String rut;
    @Column(name="nombre",nullable = false)
    private String nombre;

    @Column(name="apellido",nullable = false)
    private String apellido;

    @Column(name="direccion",nullable = false)
    private String direccion;

    @Column(name="telefono",nullable = true)
    private int telefono;






}
