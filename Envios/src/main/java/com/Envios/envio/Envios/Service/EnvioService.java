package com.Envios.envio.Envios.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Envios.envio.Envios.Model.Envio;
import com.Envios.envio.Envios.Repository.EnvioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class EnvioService {
    
    @Autowired
    private EnvioRepository envioRepository;

    public List<Envio> findAll(){
        return envioRepository.findAll();
    }

    public Envio findbyIdEnvio(long id){
        return envioRepository.findById(id).get();
    }

    public Envio save(Envio envio){
        return envioRepository.save(envio);
    }

    public void delete(long id){
        envioRepository.deleteById(id);
    }
}
