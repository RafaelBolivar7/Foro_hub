package apirest.foroHub.controller;

import apirest.foroHub.domain.usuario.UsuarioRepository;
import apirest.foroHub.domain.usuario.UsuarioService;
import apirest.foroHub.domain.usuario.dto.RegistroUsuarioDTO;
import apirest.foroHub.domain.usuario.dto.RespuestaUsuarioDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/signin")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping
    @Transactional
    public ResponseEntity<?> registrarUsuario(@RequestBody @Valid RegistroUsuarioDTO registroUsuarioDTO,
                                               UriComponentsBuilder uriComponentsBuilder){
        try{
            RegistroUsuarioDTO usuario = usuarioService.registrarUsuario(registroUsuarioDTO);
            RespuestaUsuarioDTO respuestaUsuarioDTO;
            respuestaUsuarioDTO = new RespuestaUsuarioDTO(usuario.id(), usuario.nombre());
            URI url = uriComponentsBuilder.path("usuario/{id}").buildAndExpand(usuario.id()).toUri();

            return ResponseEntity.created(url).body(respuestaUsuarioDTO);
        }catch (ConstraintViolationException e){
            return  ResponseEntity.badRequest().body("Validación fallida"+ e.getMessage());
        }
    }
}
