package br.com.helpets.helpetsapi.comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioController(final ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    //C do CRUD - Criar comentário
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/comentarios")
    public Comentario save(@RequestBody Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    //R do CRUD - Mostrar todos os comentários
    @GetMapping("/comentarios")
    public List<Comentario> findAll(){
        return comentarioRepository.findAll();
    }

    //U do CRUD - Update de comentário por usuário
    /* TODO - Update comentário - esperando classe Padrinho
    TODO - path: usuario/usuarioId/cometario/comentarioId, variaveis: idUsuario e idComentario
    @PatchMapping("/comentarios/update/{padrinho}")
    public void updateByName(@PathVariable Padrinho padrinho, @RequestParam String texto){
        comentarioRepository.updateComentariobyPadrinho(padrinho, texto);
    }
     */

    //D do CRUD - deletar comentário
    //TODO - path: usuario/usuarioId/cometario/comentarioId, variaveis: idUsuario e idComentario
    @DeleteMapping("/comentarios/{idComentario}")
    public void delete(@PathVariable Long idComentario){
        comentarioRepository.deleteById(idComentario);
    }


}
