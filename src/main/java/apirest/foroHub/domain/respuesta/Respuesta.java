package apirest.foroHub.domain.respuesta;


import apirest.foroHub.domain.respuesta.dto.RespuestaActualizadaDTO;
import apirest.foroHub.domain.topic.Topico;
import apirest.foroHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name="Respuesta")
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaCreacion;
    private String solucion;
    @OneToOne
    @JoinColumn(name="autor-id")
    private Usuario autor;
    @OneToOne
    @JoinColumn(name="topico-id")
    private Topico topico;
    private boolean activo;

    public Respuesta(Long id, String solution, Usuario usuario, Topico topico, LocalDateTime fechaCreacion) {
        this.id=id;
        this.solucion=solution;
        this.autor=usuario;
        this.topico=topico;
        this.fechaCreacion =LocalDateTime.now();
    }

    public void respuestaActualizada(RespuestaActualizadaDTO respuestaActualizadaDTO) {
        if (respuestaActualizadaDTO.solucion() != null){
            this.solucion=respuestaActualizadaDTO.solucion();
        }
    }
    public void diactivateResponse(){

        this.activo=false;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getSolucion() {
        return solucion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Topico getTopico() {
        return topico;
    }

    public boolean isActivo() {
        return activo;
    }
}