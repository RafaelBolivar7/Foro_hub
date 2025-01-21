package apirest.foroHub.controller;

import apirest.foroHub.domain.usuario.Usuario;
import apirest.foroHub.domain.usuario.dto.UsuarioDTO;
import apirest.foroHub.infra.security.JWTTokenDTO;
import apirest.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        try{
            Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioDTO.email(), usuarioDTO.password());
            System.out.println(authToken);
            System.out.println(usuarioDTO);
            var autenticacionUsuario = authenticationManager.authenticate(authToken);
            System.out.println(autenticacionUsuario);
            var JWTToken = tokenService.generarToken((Usuario) autenticacionUsuario.getPrincipal());
            //return ResponseEntity.ok(new JWTTokenDTO(token));
            System.out.println(JWTToken);
            return ResponseEntity.ok(new JWTTokenDTO(JWTToken));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales invalidas");
        }
    }
}


//import apirest.foroHub.domain.usuario.Usuario;
//import apirest.foroHub.domain.usuario.dto.UsuarioDTO;
//import apirest.foroHub.infra.security.JWTTokenDTO;
//import apirest.foroHub.infra.security.TokenService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/login")
//public class AutenticacionController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity usuarioAutenticacion(@RequestBody @Valid UsuarioDTO usuarioDTO) {
//        Authentication authToken = new UsernamePasswordAuthenticationToken(usuarioDTO.email(), usuarioDTO.password());
//        var autenticacionUsuario = authenticationManager.authenticate(authToken);
//        var token = tokenService.generarToken((Usuario) autenticacionUsuario.getPrincipal());
//        return ResponseEntity.ok(new JWTTokenDTO(token));
//    }
//}
