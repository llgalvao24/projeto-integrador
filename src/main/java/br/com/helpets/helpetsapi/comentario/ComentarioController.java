package br.com.helpets.helpetsapi.comentario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioController(final ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    //R do CRUD - Mostrar todos os comentarios
    @GetMapping("/comentarios")
    public List<Comentario> findAll(){
        return comentarioRepository.findAll();
    }
}
