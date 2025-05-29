package com.perfumelandiaspa.usuario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfumelandiaspa.usuario.Model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
    Rol findByNombre(String nombre);
}
