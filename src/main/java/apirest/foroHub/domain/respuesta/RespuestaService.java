package apirest.foroHub.domain.respuesta;

import apirest.foroHub.domain.respuesta.dto.RespuestaCreadaDTO;
import apirest.foroHub.domain.respuesta.dto.RespuestaDTO;
import apirest.foroHub.domain.topic.TopicoRepository;
import apirest.foroHub.domain.usuario.UsuarioRepository;
import apirest.foroHub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository repository;

    public RespuestaCreadaDTO respuestaCreadaDTO(RespuestaDTO respuestaDTO) {
        if (!usuarioRepository.findById(respuestaDTO.idUsuario()).isPresent()){
            throw new ValidacionDeIntegridad("Este ID de usuario no está registrado en la base de datos. ");
        }
        if (!topicoRepository.findById(respuestaDTO.idTopico()).isPresent()){
            throw new ValidacionDeIntegridad("Este id de tópico no está registrado en la base de datos. ");
        }
        var usuario = usuarioRepository.findById(respuestaDTO.idUsuario()).get();
        var topico =topicoRepository.findById(respuestaDTO.idTopico()).get();

        var rVerified= new Respuesta(null,respuestaDTO.solucion(),usuario,topico,respuestaDTO.fechaCreacion());
        repository.save(rVerified);
        return new RespuestaCreadaDTO(rVerified);
    }

}