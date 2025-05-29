package com.perfumelandiaspa.vendedores.Model.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //se declara como entidad
@Table(name = "vendedores")
@Data
public class VendedorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId; //FK opcional para el futuro

    private String sucursal; //atributo directo, no hay relacion JPA

    @Column(name = "meta_mensual")
    private Double metaMensual;


}
