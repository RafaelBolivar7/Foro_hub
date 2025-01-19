package apirest.foroHub.domain.respuesta.dto;

import apirest.foroHub.domain.respuesta.Respuesta;

import java.time.LocalDateTime;

public record ListarRespuestasDTO(Long id,
                                  String solucion,
                                  Long idUsuario,
                                  Long idTopico,
                                  LocalDateTime fechaCreacion) {
    public ListarRespuestasDTO(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getSolucion(),
                respuesta.getAutor().getId(),
                respuesta.getTopico().getId(),
                respuesta.getFechaCreacion());
    }
}