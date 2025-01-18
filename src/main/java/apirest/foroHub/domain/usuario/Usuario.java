package apirest.foroHub.domain.usuario;

import apirest.foroHub.domain.usuario.dto.ActualizacionUsuarioDTO;
import apirest.foroHub.domain.usuario.dto.RegistroUsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean activo;

    public Usuario(RegistroUsuarioDTO registroUsuarioDTO) {
        this.nombre = registroUsuarioDTO.name();
        this.email = registroUsuarioDTO.email();
        this.password = registroUsuarioDTO.password();
        /*this.perfil = registroUsuarioDTO.perfil();*/
    }

    public Usuario(RegistroUsuarioDTO registroUsuarioDTO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.nombre = registroUsuarioDTO.name();
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

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Usuario usuario = (Usuario) o;
        return getId() != null && Objects.equals(getId(), usuario.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}