package apirest.foroHub.infra.security;

//import apirest.foroHub.domain.usuario.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AutenticacionService implements UserDetailsService {
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return usuarioRepository.findByEmail(username);
//    }
//}



import apirest.foroHub.domain.usuario.Usuario;
import apirest.foroHub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = (Usuario) usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el email: " + username);
        }
        return usuario;
    }
}



//import apirest.foroHub.domain.usuario.Usuario;
//import apirest.foroHub.domain.usuario.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

//@Service
//public class AutenticacionService implements UserDetailsService {
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = (Usuario) usuarioRepository.findByEmail(username);
//        if (usuario ==null){
//            throw  new UsernameNotFoundException("Usuario no encontrado");
//        }
//
//        return new User(usuario.getEmail(), usuario.getPassword(), usuario.getAuthorities());
//    }
//}