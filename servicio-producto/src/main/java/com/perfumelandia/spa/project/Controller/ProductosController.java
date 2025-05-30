package com.perfumelandia.spa.project.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandia.spa.project.Model.Producto;
import com.perfumelandia.spa.project.Model.Entity.ProductoEntity;
import com.perfumelandia.spa.project.Service.ProductoService;

@RestController
public class ProductosController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("crearProducto")
    //Response Entity -- responder segun accion o resultado
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    @GetMapping("obtenerProductoPorId/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable int id){
        Producto producto = productoService.obtenerProducto(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("eliminarProducto/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id){
        Producto producto = productoService.obtenerProducto(id);
        if (producto != null){
            return ResponseEntity.ok(productoService.eliminarProducto(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("productos")
    public ResponseEntity<List<ProductoEntity>> listarProductos(){
        List<ProductoEntity> lista = productoService.listarProductos();
        if (lista != null){
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("productos/{nombreCategoria}")
    public ResponseEntity<List<ProductoEntity>> listarPorCategoria(@PathVariable String nombreCategoria){
        List<ProductoEntity> lista = productoService.listarPorCategoria(nombreCategoria);
        if (lista != null){
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("productos/{nombreMarca}")
    public ResponseEntity<List<ProductoEntity>> listarPorMarca(@PathVariable String nombreMarca){
        List<ProductoEntity> lista = productoService.listarPorMarca(nombreMarca);
        if (lista != null){
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
