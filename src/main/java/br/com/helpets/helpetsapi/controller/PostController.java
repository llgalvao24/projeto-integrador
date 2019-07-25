package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Post;
import br.com.helpets.helpetsapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PostController {

    private final PostRepository postRepository;

    @Autowired
    public PostController(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //C do CRUD - Criar post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/posts")
    public Post save(@RequestBody Post post){
        return postRepository.save(post);
    }

    //R do CRUD - Mostrar todos os post
    @GetMapping("/posts")
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    //U do CRUD - Update de comentário por usuário
    /* TODO - Update comentário - esperando classe Padrinho
    TODO - path: usuario/usuarioId/cometario/postId, variaveis: idUsuario e idPost
    @PatchMapping("/posts/update/{padrinho}")
    public void updateByName(@PathVariable Padrinho padrinho, @RequestParam String texto){
        postRepository.updatePostbyPadrinho(padrinho, texto);
    }
     */

    //D do CRUD - deletar comentário
    //TODO - path: usuario/usuarioId/cometario/postId, variaveis: idUsuario e idPost
    @DeleteMapping("/posts/{idPost}")
    public void delete(@PathVariable Long idPost){
        postRepository.deleteById(idPost);
    }


}
