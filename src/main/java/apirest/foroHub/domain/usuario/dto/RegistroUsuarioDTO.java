package apirest.foroHub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

    public record RegistroUsuarioDTO(
            Long id, @NotBlank
    String name,
            @NotBlank (message = "Utilice su correo electrónico como nombre de usuario")
            @Email
            String username,
            @NotBlank
            String email,
            @NotBlank(message = "Debe tener entre 6 y 10 caracteres.") @Pattern(regexp = "\\d{6,10}")
            String password

            /*Perfil perfil*/  //Para desarrollar la visualizacion de los perfiles
    ) {
}
