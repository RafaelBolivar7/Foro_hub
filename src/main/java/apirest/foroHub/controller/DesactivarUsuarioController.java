package apirest.foroHub.controller;

import apirest.foroHub.domain.usuario.UsuarioService;
import apirest.foroHub.domain.usuario.dto.RegistroUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class DesactivarUsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @DeleteMapping("/desactivar/{id}")
    public ResponseEntity<?> desactivarUsuario(@PathVariable Long id){
        try{
            RegistroUsuarioDTO respuesta = usuarioService.desactivarUser(id);
            return  ResponseEntity.ok(respuesta);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
