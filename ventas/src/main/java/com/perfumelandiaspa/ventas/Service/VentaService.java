package com.perfumelandiaspa.ventas.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandiaspa.ventas.Model.Venta;
import com.perfumelandiaspa.ventas.Model.Entity.VentaEntity;
import com.perfumelandiaspa.ventas.Repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;



    //Metodo crear venta
    public String crearVenta(Venta solicitudVenta){
        try{

            //Validacion en caso de que ya exista una venta por la misma id
            Optional<VentaEntity> ventaExiste = ventaRepository.findById(solicitudVenta.getIdVenta());
            if (ventaExiste.isPresent()) {
                return "La venta ya existe";
            }

            //Convierte venta a VentaEntity
            VentaEntity nuevaVenta = new VentaEntity();
            nuevaVenta.setIdVenta(solicitudVenta.getIdVenta());
            nuevaVenta.setIdCliente(solicitudVenta.getIdCliente());
            nuevaVenta.setIdVendedor(solicitudVenta.getIdVendedor());
            nuevaVenta.setFechaVenta(solicitudVenta.getFechaVenta());
            nuevaVenta.setTotalVenta(solicitudVenta.getTotalVenta());
            ventaRepository.save(nuevaVenta);
            return "Venta creada correctamente";
        }
        catch(Exception e){
            return "Error al crear la venta " + e.getMessage();
        }
    }


    //Metodo para buscar pod id de la venta
    // public List<Venta> buscarVentaPorCliente(Long idCliente){
    //     try{

    //         List<VentaEntity> ventaEntity = VentaRepository.findById(idCliente);
    //         return ventaEntity.stream().map(
    //             entidad  -> {
                    

    //             }


    //         )


    //     }
    //     catch(Exception e){

    //     }
    // }
}
