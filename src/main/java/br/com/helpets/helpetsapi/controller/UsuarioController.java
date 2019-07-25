package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Usuario;
import br.com.helpets.helpetsapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // CREATE

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuarios")
    public Usuario save(@Valid @RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    // READ

    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    // UPDATE

    @PatchMapping("/usuarios/atualiza/{id}")
    public void updateNome(@PathVariable Long id, @RequestParam String nome){
        usuarioRepository.updateNome(nome, id);
    }

    // DELETE

    public void delete(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }

}
