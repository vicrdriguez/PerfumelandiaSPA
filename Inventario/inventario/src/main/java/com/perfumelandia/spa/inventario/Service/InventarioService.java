package com.perfumelandia.spa.inventario.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfumelandia.spa.inventario.Model.Inventario;
import com.perfumelandia.spa.inventario.Model.InventarioEntity;
import com.perfumelandia.spa.inventario.Repository.InventarioRepository;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;
    

    public Inventario obtenerInventario(int id){
        try {
            InventarioEntity inventario = inventarioRepository.findByIdInventario(id);
            if (inventario != null){
                Inventario invFinded = new Inventario(
                    inventario.getIdInventario(),
                    inventario.getIdProducto(),
                    inventario.getCantidadDisponible(),
                    inventario.getCantidadMinima(),
                    inventario.getEstado()
                );
                return invFinded;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String crearInventario(Inventario inv){
        try {
            boolean estado = inventarioRepository.existsById(inv.getIdInventario());
            if (!estado){
                InventarioEntity newInv = new InventarioEntity(
                    inv.getIdInventario(),
                    inv.getIdProducto(),
                    inv.getCantidadDisponible(),
                    inv.getCantidadMinima(),
                    inv.getEstado()
                );
                inventarioRepository.save(newInv);
                return "Inventario creado con exito";
            }
            return "El inventario ya existe";
        } catch (Exception e) {
            return "error";
        }
    }

    public String eliminarInventario(int id){
        try {
            InventarioEntity inv = inventarioRepository.findByIdInventario(id);
            if (inv != null) {
                inventarioRepository.deleteById(id);
                return "Se borro el producto de ID: " + id;
            }
            return "No se encontro el inventario con el ID: " + id;
        } catch (Exception e) {
            return "Error";
        }
    }

    
}
