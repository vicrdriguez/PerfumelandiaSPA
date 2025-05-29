package com.perfumelandiaspa.envio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perfumelandiaspa.envio.Model.Entity.EnvioEntity;

//aca el usuario interactua con la entidad a traves de el repositorio
@Repository
public interface EnvioRepository extends JpaRepository<EnvioEntity, Integer> {
    //aqui se contruyen sus metodos
    EnvioEntity findByIdEnvio(int idEnvio);
    Boolean existsByIdEnvio(int idEnvio);
    void deleteByIdEnvio(int idEnvio);

}
