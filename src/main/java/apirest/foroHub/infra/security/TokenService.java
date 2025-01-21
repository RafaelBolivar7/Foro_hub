package apirest.foroHub.infra.security;

import apirest.foroHub.domain.usuario.Usuario;
import apirest.foroHub.domain.usuario.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("ForoHub")
                    .withSubject(usuario.getEmail())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(expirationdate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al generar el token");
        }
    }
    public String getSubject(String token){
        if (token == null) {
            throw new IllegalArgumentException("El token es nulo.");
        }
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            String username = decodedJWT.getSubject();
            if (username == null) {
                throw new IllegalArgumentException("Token no válido: Asunto no encontrado");
            }
            Usuario usuario = (Usuario) usuarioRepository.findByEmail(username);
            if (usuario == null) {
                throw new IllegalArgumentException("Usuario no encontrado por nombre de usuario: " + username);
            }

            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("ForoHub")
                    .build()
                    .verify(token);

            return verifier.getSubject();
        } catch (JWTVerificationException | IllegalArgumentException e) {
            throw new IllegalArgumentException("Token no válido: " + e.getMessage(), e);
        }
    }
    private Instant expirationdate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}

//package apirest.foroHub.infra.security;
//
//import apirest.foroHub.domain.usuario.Usuario;
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTVerificationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//@Service
//public class TokenService {
//
//    @Value("${api.security.secret}")
//    private String apiSecret;
//
//    public String generarToken(Usuario usuario) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
//            return JWT.create()
//                    .withIssuer("foroHub")
//                    .withSubject(usuario.getEmail())
//                    .withClaim("id", usuario.getId())
//                    .withExpiresAt(expirationDate())
//                    .sign(algorithm);
//        } catch (Exception e) {
//            throw new RuntimeException("Error al generar el token", e);
//        }
//    }
//
//    public String getSubject(String token) {
//        if (token == null){
//            throw new RuntimeException("El token es nulo");
//
//        }
//        DecodedJWT verifier = null;
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
//            verifier = JWT.require(algorithm)
//                    .withIssuer("foroHub")
//                    .build()
//                    .verify(token);
//            verifier.getSubject();
//        } catch (JWTVerificationException e) {
//            throw new RuntimeException("Token inválido o expirado", e);
//        }
//        if(verifier.getSubject() == null)
//        {
//            throw new RuntimeException("Verifier invalido");
//        }
//        return verifier.getSubject();
//    }
//
////    public String getSubject(String token) {
////        if (token == null) {
////            throw new RuntimeException("Token no puede ser nulo");
////        }
////        try {
////            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
////            DecodedJWT decodedJWT = JWT.require(algorithm)
////                    .withIssuer("ForoHub")
////                    .build()
////                    .verify(token);
////
////            String subject = decodedJWT.getSubject();
////            if (subject == null) {
////                throw new RuntimeException("El token no contiene un subject válido");
////            }
////            return subject;
////        } catch (JWTVerificationException e) {
////            throw new RuntimeException("Token inválido o expirado", e);
////        }
////    }
//
//
//    private Instant expirationDate() {
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
//    }
//}

