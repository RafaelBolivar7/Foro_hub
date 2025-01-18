package apirest.foroHub.domain.topic;


import apirest.foroHub.domain.topic.dto.RespuestaTopicoDTO;
import apirest.foroHub.domain.topic.dto.TopicoDTO;
import apirest.foroHub.domain.usuario.UsuarioRepository;
import apirest.foroHub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public RespuestaTopicoDTO topicoCreado(TopicoDTO topicoDTO){
        if (!usuarioRepository.findById(topicoDTO.idUsuario()).isPresent()){
            throw new ValidacionDeIntegridad("El ID de usuario no se encuentra registrado dentro la base de datos.");
        }
        var titulo= topicoDTO.titulo();
        if (titulo != null && topicoRepository.existsByTituloIgnoreCase(titulo)){
            throw new ValidacionDeIntegridad("El título ya se ecnuentra registrado en la base de datos. Por favor revisar el tópico existente.");
        }
        String message = topicoDTO.mensaje();
        if (message != null && topicoRepository.existsByMensajeIgnoreCase(message)){
            throw new ValidacionDeIntegridad("Este mensaje ya está presente en la base de datos. Por favor revise el tópico existente.");
        }
        var usuario = usuarioRepository.findById(topicoDTO.idUsuario()).get();
        var topicoId= new Topico(null,titulo,message,topicoDTO.fecha(),topicoDTO.status(),usuario,topicoDTO.curso());
        topicoRepository.save(topicoId);
        return new RespuestaTopicoDTO(topicoId);
    }
}