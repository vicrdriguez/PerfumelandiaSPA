package com.perfumelandiaspa.usuario.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perfumelandiaspa.usuario.Model.Usuario;
import com.perfumelandiaspa.usuario.Service.UsuarioService;

@RestController
@RequestMapping("/autenticar")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //POST /autenticar/registro
    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(
        @RequestBody Usuario usuario,
        @RequestParam String rol 
    ) {
        return usuarioService.registrarUsuario(usuario, rol);
    }
    
    //GET /usuarios/{id}
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id)
    {
        Usuario usuario = usuarioService.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        return ResponseEntity.ok(usuario);
    }

    //GET /usuarios/rol/{tipo}
    @GetMapping("/usuarios/rol/{tipo}")
    public ResponseEntity<?> getUsuarioPorRol(@PathVariable String tipo)
    {
        if (!tipo.equals("CLIENTE") && !tipo.equals("VENDEDOR")) {
            return ResponseEntity.badRequest().body("El rol debe ser CLIENTE o VENDEDOR");
        }
        return ResponseEntity.ok(usuarioService.listarPorRol(tipo));
    }
}
