package apirest.foroHub.domain.respuesta.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaActualizadaDTO(
        @NotNull Long id,
        String solucion,
        @NotNull Long idUsuario,
        @NotNull Long idTopico,
        LocalDateTime fechaCreacion
) {
}