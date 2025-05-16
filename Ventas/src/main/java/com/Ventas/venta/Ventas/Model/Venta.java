package com.Ventas.venta.Ventas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "venta")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID" ,nullable = false)
    private Long id;

    @Column(name = "Total",nullable = false)
    private Integer total;





}
