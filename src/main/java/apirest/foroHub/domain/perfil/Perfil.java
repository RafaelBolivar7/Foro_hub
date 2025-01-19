//package apirest.foroHub.domain.perfil;
//
//import apirest.foroHub.domain.perfil.dto.ActualizarPerfilDTO;
//import apirest.foroHub.domain.topic.Topico;
//import apirest.foroHub.domain.usuario.Usuario;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity(nombre = "Perfil")
//@Table(nombre = "perfiles")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
//public class Perfil {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String nombre;
//    private String email;
//    private Boolean activo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nombre = "id_user")
//    private Usuario usuario;
//
//    @OneToMany(mappedBy = "perfil",  cascade = CascadeType.ALL)
//    private List<Topico> topicos;
//
//    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
//    private List<Respuesta> respuestas;
//
//    public void actualizarDatos(ActualizarPerfilDTO actualizarPerfilDTO) {
//        if (actualizarPerfilDTO.nombre() != null) {
//            this.nombre = actualizarPerfilDTO.nombre();
//        }
//        if (actualizarPerfilDTO.email() != null) {
//            this.email = actualizarPerfilDTO.email();
//        }
//    }
//
//    public void desactivarPerfil() {
//        this.activo = false;
//    }
//}
