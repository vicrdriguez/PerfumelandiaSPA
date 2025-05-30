package com.perfumelandia.spa.inventario.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandia.spa.inventario.Model.Almacen;
import com.perfumelandia.spa.inventario.Model.AlmacenEntity;
import com.perfumelandia.spa.inventario.Repository.AlmacenRepository;

@Service
public class AlmacenService {
    @Autowired
    private AlmacenRepository almacenRepository;
    public String crearAlmacen(Almacen alm){
        try {
            boolean estado = almacenRepository.existsById(alm.getIdAlmacen());
            if (!estado){
                AlmacenEntity newAlm = new AlmacenEntity();
                    newAlm.setNombre(alm.getNombre());
                    newAlm.setUbicacion(alm.getUbicacion());
                almacenRepository.save(newAlm);
                return "Inventario creado con exito";
            }
            return "El inventario ya existe";
        } catch (Exception e) {
            return "error";
        }
    }
}
