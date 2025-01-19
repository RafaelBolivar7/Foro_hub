package apirest.foroHub.domain.respuesta.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RespuestaDTO(
        @NotBlank
        String solucion,
        @NotNull
        @Valid
        Long idUsuario,
        @NotNull
        @Valid
        Long idTopico,
        LocalDateTime fechaCreacion) {
}