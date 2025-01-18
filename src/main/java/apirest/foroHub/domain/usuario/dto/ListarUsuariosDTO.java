package apirest.foroHub.domain.usuario.dto;

import apirest.foroHub.domain.usuario.Usuario;

public record ListarUsuariosDTO (
        Long id,
        String nombre,
        String email
){
    public ListarUsuariosDTO(Usuario usuario){

        this(usuario.getId(),usuario.getNombre(),usuario.getEmail());
    }
}