package com.perfumelandiaspa.venta.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandiaspa.venta.Model.Venta;
import com.perfumelandiaspa.venta.Model.Entity.VentaEntity;
import com.perfumelandiaspa.venta.Repository.VentaRepository;

//aca van las reglas del negocio, se conecta con las otras clases para interactuar
//es la capa intermedia del servicio entre controller y repository
@Service
public class VentaService {

    @Autowired //una anotacion
    private VentaRepository ventaRepository;

    //metodo para crear ventas y validando si existen
    public String crearVenta(Venta ventaRequest)
    {
        try {
            //valida si existe, con el optional se evitan nulls
            Optional<VentaEntity> ventaExiste = ventaRepository.findById(ventaRequest.getIdVenta());
            
            if (ventaExiste.isPresent()) {
                return "La venta ya existe";
            }

            //aca convierte Venta --> VentaEntity
            VentaEntity nuevaVenta = new VentaEntity();
            nuevaVenta.setId(ventaRequest.getIdVenta());
            nuevaVenta.setFecha(ventaRequest.getFechaVenta());
            nuevaVenta.setTotal(ventaRequest.getTotalVenta());
            nuevaVenta.setClienteId(ventaRequest.getIdCliente());
            nuevaVenta.setVendedorId(ventaRequest.getIdVendedor());
            ventaRepository.save(nuevaVenta);
            return "Venta creada correctamente";
        } catch (Exception e) {
            return "Error al crear la venta: " + e.getMessage();
        }
    }


    //metodo para buscar por ID 
    public Venta buscarVentaPorId(Long idVenta)
    {
        try {
            Optional<VentaEntity> ventaEntity = ventaRepository.findById(idVenta);

            if (ventaEntity.isPresent()) {
                VentaEntity entidad = ventaEntity.get();
                
                Venta ventaResponse = new Venta();
                ventaResponse.setIdVenta(entidad.getId());
                ventaResponse.setIdCliente(entidad.getClienteId());
                ventaResponse.setIdVendedor(entidad.getVendedorId());
                ventaResponse.setFechaVenta(entidad.getFecha());
                ventaResponse.setTotalVenta(entidad.getTotal());

                return ventaResponse;
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace(); //para debug
            return null;
        }
    }
    

    //Metodo para buscar ventas por ID de cliente
    public List<Venta> buscarVentaPorCliente(Long clienteId)
    {
        try {
            List<VentaEntity> ventasEntity = ventaRepository.findByClienteId(clienteId); //asume que el repositorio tiene este metodo

            //convierte List<VentaEntity> a List<Venta>
            return ventasEntity.stream().map(
                entidad -> {
                    Venta venta = new Venta();
                    venta.setIdVenta(entidad.getId());
                    venta.setIdCliente(entidad.getClienteId());
                    venta.setIdVendedor(entidad.getVendedorId());
                    venta.setFechaVenta(entidad.getFecha());
                    venta.setTotalVenta(entidad.getTotal());
                    return venta;
                }).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of(); //retorna lista vacia si hay error
        }
    }
}