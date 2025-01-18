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
    public RespuestaTopicoDTO(Topico topicoId) {
        this(
                topicoId.getId(),
                topicoId.getTitulo(),
                topicoId.getMensaje(),
                topicoId.getStatus(),
                topicoId.getAutor().getId(),
                topicoId.getCurso(),
                topicoId.getFechaCreacion());
    }
}