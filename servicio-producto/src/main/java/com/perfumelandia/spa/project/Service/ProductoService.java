package com.perfumelandia.spa.project.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfumelandia.spa.project.Model.Producto;
import com.perfumelandia.spa.project.Model.Entity.ProductoEntity;
import com.perfumelandia.spa.project.Repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public String crearProducto(Producto producto)
    {
        try {
            boolean estado = productoRepository.existsByNombre(producto.getNombre());
            if (!estado) {
                ProductoEntity prodNew = new ProductoEntity();
                prodNew.setNombre(producto.getNombre());
                prodNew.setPrecio(producto.getPrecio());
                prodNew.setIdMarca(producto.getIdMarca());

                productoRepository.save(prodNew);
                return "Producto creado correctamente";
            }
            return "El producto ya existe";
        } catch (Exception e) {
            return "Error al crear producto";
        }

        
    } 
    public Producto obtenerProducto(int id){
        try {
            ProductoEntity producto = productoRepository.findByIdProducto(id);
            if (producto != null) {
                Producto prodFinded = new Producto(
                    producto.getIdProducto(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getIdMarca(),
                    producto.getIdCategoria()
                );
                return prodFinded;
                
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String eliminarProducto(int id){
        try {
            ProductoEntity producto = productoRepository.findByIdProducto(id);
            if (producto != null){
                productoRepository.deleteById(id);
                return "Se borro el producto de ID:" + id;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<ProductoEntity> listarProductos(){
        return productoRepository.findAll();
    }

    public List<ProductoEntity> listarPorCategoria(String categoria){
        int idCategoria = categoriaNombreToId.get(categoria);
        return productoRepository.findByIdCategoria(idCategoria);
    }

    public List<ProductoEntity> listarPorMarca(String marca){
        int idMarca = marcaNombreToId.get(marca);
        return productoRepository.findByIdCategoria(idMarca);
    }



    public static final Map<String, Integer> categoriaNombreToId = Map.of(
        "Cuidado Facial", 1,
        "Cuidado Corporal", 2,
        "Maquillaje", 3,
        "Perfumeria", 4,
        "Cabello", 5

    );

    public static final Map<String, Integer> marcaNombreToId = Map.of(
        "Cerave", 10,
        "Avon", 20,
        "FullClean", 30,
        "SpiceAndOld", 40,
        "Popeye", 50

    );

    public List<ProductoEntity> buscarPorIds(List<Integer> ids){
        List<ProductoEntity> productos = productoRepository.findAllById(ids);
        return(productos);


        
    }
}
