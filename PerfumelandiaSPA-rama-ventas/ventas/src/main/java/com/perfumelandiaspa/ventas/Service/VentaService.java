package com.perfumelandiaspa.ventas.Service;



import java.net.http.HttpHeaders;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.perfumelandiaspa.ventas.Model.Boleta;
import com.perfumelandiaspa.ventas.Model.ClienteDto;
import com.perfumelandiaspa.ventas.Model.ProductoDTO;
import com.perfumelandiaspa.ventas.Model.VentaRequest;
import com.perfumelandiaspa.ventas.Model.Entity.VentaEntity;
import com.perfumelandiaspa.ventas.Repository.VentaRepository;

@Service
public class VentaService {


    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private RestTemplate restTemplate;

    private final String clienteServiceURL = "http://localhost:8081/clientes/clientesPorID";
    private final String productoServiceURL = "http://localhost:8083/productosPorId";





    

    
    public Boleta generarBoleta(VentaRequest ventaRequest){
        //Obtiene la informacion de cliente
        String url = clienteServiceURL + "/" + ventaRequest.getIdCliente();
        ClienteDto cliente = restTemplate.getForObject(url, ClienteDto.class);

        List<Integer> ids = ventaRequest.getProductos();
        List<ProductoDTO> productos = obtenerProductosPorIds(ids);
        
        double total = productos.stream()
        .mapToDouble(ProductoDTO::getPrecio)
        .sum();
        double totalRedondeado = Math.round(total * 100.0) / 100.0;

        Boleta boleta = new Boleta();

            boleta.setCliente(cliente);
            boleta.setProductos(productos);
            boleta.setTotal(totalRedondeado);
            
            
        
        return boleta;
    }

    public List<VentaEntity> listarBoletas(){
        return ventaRepository.findAll();
    }

    public List<ProductoDTO> obtenerProductosPorIds(List<Integer> ids) {
    HttpEntity<List<Integer>> requestEntity = new HttpEntity<>(ids);
    
    ResponseEntity<List<ProductoDTO>> response = restTemplate.exchange(
        productoServiceURL,
        HttpMethod.POST,
        requestEntity,
        new ParameterizedTypeReference<List<ProductoDTO>>() {}
    );
    
    return response.getBody();
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
