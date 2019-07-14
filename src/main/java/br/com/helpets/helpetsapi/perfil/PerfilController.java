package br.com.helpets.helpetsapi.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    //CREATE

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/perfil")
    public Perfil save(@RequestBody Perfil perfil){
        return perfilRepository.save(perfil);
    }

    //READ

    @GetMapping("/perfil")
    public List<Perfil> findAll(){
        return perfilRepository.findAll();
    }

    @GetMapping("/perfil/{id}")
    public Optional<Perfil> findById(@PathVariable Long id){
        return perfilRepository.findById(id);
    }

    @PostMapping("/perfil/nome")
    public List<Perfil> findByName(@RequestParam String nome){
        return perfilRepository.findByName(nome);
    }

    // UPDATE

    @PatchMapping("/perfil/atualiza/{id}")
    public void updateNome(@PathVariable Long id, @RequestParam String nome){
        perfilRepository.updateNome(nome, id);
    }

    // Fazer o método update com todos os outros campos da tabela


    // DELETE

    @DeleteMapping("/perfil/{id}")
    public void delete(@PathVariable Long id){
        perfilRepository.delete(id);
    }

}
