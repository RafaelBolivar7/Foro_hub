package apirest.foroHub.domain.usuario;

import apirest.foroHub.domain.usuario.dto.ActualizacionUsuarioDTO;
import apirest.foroHub.domain.usuario.dto.RegistroUsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(nullable = false)
    private String nombre;

    @Getter
    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean activo;

    public Usuario(RegistroUsuarioDTO registroUsuarioDTO) {
        this.nombre = registroUsuarioDTO.nombre();
        this.email = registroUsuarioDTO.email();
        this.password = registroUsuarioDTO.password();
        /*this.perfil = registroUsuarioDTO.perfil();*/
    }

    public Usuario(RegistroUsuarioDTO registroUsuarioDTO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.nombre = registroUsuarioDTO.nombre();
        this.username = registroUsuarioDTO.username();
        this.email = registroUsuarioDTO.email();
        this.password = bCryptPasswordEncoder.encode(registroUsuarioDTO.password());
        this.activo = true;
    }

    public void actualizacionUsuario(ActualizacionUsuarioDTO actualizacionUsuarioDTO) {
        if (actualizacionUsuarioDTO.nombre() != null) {
            this.nombre = actualizacionUsuarioDTO.nombre();
        }
        if (actualizacionUsuarioDTO.email() != null) {
            this.email = actualizacionUsuarioDTO.email();
        }
    }

    public void deactivateUser() {
        this.activo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public Long getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }

}