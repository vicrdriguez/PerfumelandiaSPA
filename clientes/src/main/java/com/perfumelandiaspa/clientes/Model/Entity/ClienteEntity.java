package com.perfumelandiaspa.clientes.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rut_cliente", nullable = false, unique = true)
    private String rut;
    
    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    @Column(name="direccion", nullable = false)
    private String direccion;

    @Column(name="telefono", nullable = true)
    private Integer telefono;

    // relacion de  Uno a muchos
    // @OneToOne
    // @JoinColumn(name = "Usuario_id", nullable =  true)
    // private Long id_usuario;

}