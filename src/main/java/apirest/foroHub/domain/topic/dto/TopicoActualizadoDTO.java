package apirest.foroHub.domain.topic.dto;

import apirest.foroHub.domain.topic.Status;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoActualizadoDTO (@NotNull Long id,
                                    String titulo,
                                    String mensaje,
                                    Status status,
                                    @NotNull Long idUsuario,
                                    String curso,
                                    LocalDateTime fechaCreacion){
}
