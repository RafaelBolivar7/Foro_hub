package apirest.foroHub.domain.topic;
import apirest.foroHub.domain.topic.dto.TopicoActualizadoDTO;
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
    @JoinColumn(name= "idAutor")
    private Usuario autor;
    private String curso;
    private boolean activo;

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fecha, Status status, Usuario usuario, String curso) {
        this.id=id;
        this.titulo =titulo;
        this.mensaje =mensaje;
        this.fechaCreacion = fecha;
        this.fechaCreacion =LocalDateTime.now();
        this.status=status;
        this.autor =usuario;
        this.curso =curso;
    }

    public void topicoActualizado(TopicoActualizadoDTO topicoActualizadoDTO) {
        if (topicoActualizadoDTO.titulo() !=null){
            this.titulo = topicoActualizadoDTO.titulo();
        }
        if (topicoActualizadoDTO.mensaje() != null){
            this.mensaje =topicoActualizadoDTO.mensaje();
        }
        if (topicoActualizadoDTO.status() != null){
            this.status=topicoActualizadoDTO.status();
        }
        if (topicoActualizadoDTO.curso() != null){
            this.curso =topicoActualizadoDTO.curso();
        }
    }
    public void diactivateTopic(){
        this.activo =false;
    }
}