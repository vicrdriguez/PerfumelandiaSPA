package com.perfumelandiaspa.envio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.envio.Model.Envio;
import com.perfumelandiaspa.envio.Service.EnvioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;



@RestController //el controlador trabaja con un REST
public class EnvioController { //el controller es el que interactua con el cliente
    @Autowired
    private EnvioService envioService;
    
    @PostMapping("/envios")
    //ResonseEntity <-- responder segun accion o resultado
    //404 --> no se encuentra el recurso
    //200 --> ok
    public ResponseEntity<String> obtenerEnvio(@RequestBody Envio envio) //con el RequestBody se le da el cuerpo del Json
    {   
        return ResponseEntity.ok(envioService.generarEnvio(envio));
    }


    @GetMapping("/obtenerEnvio/{idEnvio}")
    public ResponseEntity<Envio> obtenerEnvioEntity(@PathVariable int idEnvio)
    {
        Envio envio = envioService.obtenerEnvio(idEnvio);
        if (envio != null) {
            return ResponseEntity.ok(envio);
        }
        return ResponseEntity.notFound().build(); //notFound si manda un parametro que no corresponde, sigue funcionando pero manda 404
    }
    


}
