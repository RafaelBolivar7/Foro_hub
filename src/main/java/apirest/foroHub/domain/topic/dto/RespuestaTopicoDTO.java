package apirest.foroHub.domain.topic.dto;

import apirest.foroHub.domain.topic.Status;
import apirest.foroHub.domain.topic.Topico;

import java.time.LocalDateTime;

public record RespuestaTopicoDTO(
        Long id,
        String titulo,
        String message,
        Status status,
        Long idUsuario,
        String curso,
        LocalDateTime fecha) {
    public RespuestaTopicoDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso(),
                topico.getFechaCreacion());
    }
}