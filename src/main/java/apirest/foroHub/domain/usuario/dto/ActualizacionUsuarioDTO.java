package apirest.foroHub.domain.usuario.dto;

import jakarta.validation.constraints.NotNull;

public record ActualizacionUsuarioDTO(
        @NotNull Long id,
        String nombre,
        String email
) {
}