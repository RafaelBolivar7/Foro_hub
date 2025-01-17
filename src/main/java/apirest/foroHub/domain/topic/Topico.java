package apirest.foroHub.domain.topic;
import apirest.foroHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity(name="Topico")
@Table(name="topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "author_id")
    private Usuario autor;
    private String curso;
    private boolean active;

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, Status status, Usuario usuario, String curso) {
        this.id=id;
        this.titulo =titulo;
        this.mensaje =mensaje;
        this.fechaCreacion = fechaCreacion;
        this.fechaCreacion =LocalDateTime.now();
        this.status=status;
        this.autor =usuario;
        this.curso=curso;
    }
}
