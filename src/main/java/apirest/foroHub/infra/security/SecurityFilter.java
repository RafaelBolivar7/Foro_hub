//package apirest.foroHub.infra.security;
//
//import apirest.foroHub.domain.usuario.Usuario;
//import apirest.foroHub.domain.usuario.UsuarioRepository;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        try {
//            String authHeader = request.getHeader("Authorization");
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                String token = authHeader.replace("Bearer ", "");
//                String subject = tokenService.getSubject(token);
//
//                if (subject != null) {
//                    Usuario usuario = (Usuario) usuarioRepository.findByEmail(subject);
//                    if (usuario != null) {
//                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
//                        usuario.getAuthorities();
//                        SecurityContextHolder.getContext().setAuthentication(authentication);
//                    } else {
//                        throw new IllegalArgumentException("Usuario no encontrado por nombre de usuario: " + subject);
//                    }
//                }
//            }
//        } catch (IllegalArgumentException e) {
//            logger.error("Error de autenticación: " + e.getMessage(), e);
//        }
//        filterChain.doFilter(request, response);
//    }
//}

package apirest.foroHub.infra.security;

import apirest.foroHub.domain.usuario.Usuario;
import apirest.foroHub.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println("el filtro esta siendo llamado");

        var authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        if (authHeader != null) {
            System.out.println("validamos que toquen no es null");
            var token = authHeader.replace("Bearer ", "");
            System.out.println(token);
            System.out.println(tokenService.getSubject(token));
            var subject = tokenService.getSubject(token);
            if (subject != null){
                //token valido
                var usuario = usuarioRepository.findByEmail(subject);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }


}
