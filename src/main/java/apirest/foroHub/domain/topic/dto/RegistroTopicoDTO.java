package apirest.foroHub.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroTopicoDTO (
        @NotBlank(message = "Título es obligatorio")
        String titulo,
        @NotBlank(message = "Mensaje es obligatorio")
        String mensaje,
        @NotBlank(message = "Curso es obligatorio")
        String curso,
        @NotNull(message = "Author_id es obligatorio")
        Long idAutor
) {

    public RegistroTopicoDTO(String titulo, String mensaje, String curso, Long idAutor){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.curso = curso;
        this.idAutor = idAutor;
    }
}