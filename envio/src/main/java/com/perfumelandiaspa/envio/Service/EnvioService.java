package com.perfumelandiaspa.envio.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandiaspa.envio.Model.Envio;
import com.perfumelandiaspa.envio.Model.Entity.EnvioEntity;
import com.perfumelandiaspa.envio.Repository.EnvioRepository;


//aca van las reglas del negocio, se conecta con las otras clases para interactuar
//es la capa intermedia del servicio entre controller y repository
@Service
public class EnvioService {
    @Autowired //una anotacion
    private EnvioRepository envioRepository;

    //metodo creado para agregarlos
    public String generarEnvio(Envio env)
    {
        try {
            Boolean estado = envioRepository.existsByIdEnvio(env.getIdEnvio());

            if (!estado) {
                EnvioEntity envioNuevo = new EnvioEntity();
                    envioNuevo.setIdEnvio(env.getIdEnvio());
                    envioNuevo.setEstado(env.getEstado());
                    envioNuevo.setFechaEstado(env.getFechaEnvio());
                    envioNuevo.setTransportista(env.getTransportista());
                    envioRepository.save(envioNuevo);
                    return "Envio generado correctamente";
                }
                return "El envio ya existe";
            } catch (Exception e) {
                return "Error al generar el envio";
            }
    }

    //metodo creado para encontrar/obtener envios
    public Envio obtenerEnvio(int idEnvio)
    {
        try {
            EnvioEntity envio = envioRepository.findByIdEnvio(idEnvio);

            if (envio != null) {
                Envio env = new Envio(
                    envio.getIdEnvio(),
                    envio.getFechaEstado(),
                    envio.getEstado(),
                    envio.getTransportista()
                );
                return env;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


}
