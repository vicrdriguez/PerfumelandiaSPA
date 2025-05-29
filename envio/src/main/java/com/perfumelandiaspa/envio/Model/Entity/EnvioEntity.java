package com.perfumelandiaspa.envio.Model.Entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //se declara como entidad
@Data

public class EnvioEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnvio;

    @Column(name = "estado")
    private String estado;

    private String fechaEstado;

    private String transportista;

}
