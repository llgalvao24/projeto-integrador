package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Comment;
import br.com.helpets.helpetsapi.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CommentController {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentController(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    //C do CRUD - Criar comentário
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/comentarios")
    public Comment save(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }

    //R do CRUD - Mostrar todos os comentários
    @GetMapping("/comentarios")
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    //U do CRUD - Update de comentário por usuário
    /* TODO - Update comentário - esperando classe Padrinho
    TODO - path: usuario/usuarioId/cometario/comentarioId, variaveis: idUsuario e idComentario
    @PatchMapping("/comments/update/{padrinho}")
    public void updateByName(@PathVariable Padrinho padrinho, @RequestParam String texto){
        comentarioRepository.updateComentariobyPadrinho(padrinho, texto);
    }
     */

    //D do CRUD - deletar comentário
    //TODO - path: usuario/usuarioId/cometario/comentarioId, variaveis: idUsuario e idComentario
    @DeleteMapping("/comentarios/{id}")
    public void delete(@PathVariable Long id){
        commentRepository.deleteById(id);
    }


}
