package com.perfumelandiaspa.ventas.Controller;

import com.perfumelandiaspa.ventas.Model.Boleta;

import com.perfumelandiaspa.ventas.Model.VentaRequest;
import com.perfumelandiaspa.ventas.Service.VentaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/venta")
public class VentaController {

    @Autowired
    private VentaService ventaservice;

    //Documentacion con Swagger crear boleta nueva
    @Operation(

        summary = "Crear una nueva boleta",
        description = "Este endPoint crea una nuevo boleta",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "boleta creada exitosamente",
                content = @Content(schema = @Schema(implementation = Boleta.class)) //Devuelve un cuerpo tipo Json
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Solicitud invalida",
                content = @Content() //No hay cuerpo en la respuesta por eso esta vacio
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Recurso no fue encontrado",
                content = @Content() //No hay cuerpo en la respuesta por eso esta vacio
            ),
            @ApiResponse(
                responseCode = "500",
                description = "Error interno en el servidor",
                content = @Content() //No hay cuerpo en la respuesta por eso esta vacio
            )
        }   
    )




    
    @PostMapping("/crearBoleta")
    public ResponseEntity<Boleta> crearBoleta(@RequestBody VentaRequest ventaRequest){

        return ResponseEntity.ok(ventaservice.generarBoleta(ventaRequest));

         
    }






    


}
