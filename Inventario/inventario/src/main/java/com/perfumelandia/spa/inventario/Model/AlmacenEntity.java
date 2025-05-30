package com.perfumelandia.spa.inventario.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlmacenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlmacen;

    private String nombre;
    private String ubicacion;
    
}
