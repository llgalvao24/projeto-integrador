package br.com.helpets.helpetsapi.padrinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PadrinhoController {

    @Autowired
    private PadrinhoRepository padrinhoRepository;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/padrinho")
    public Padrinho save(@RequestBody Padrinho padrinho) {
        return padrinhoRepository.save(padrinho);
    }

    //READ
    @GetMapping("/padrinho")
    public List<Padrinho> findAll() {
        return padrinhoRepository.findAll();
    }

    @GetMapping("/padrinho/{id}")
    public Optional<Padrinho> findById(@PathVariable Long id) {
        return padrinhoRepository.findById(id);
    }

    @PostMapping("/padrinho/nome")
    public Optional<Padrinho> findByName(@RequestParam String nome) {
        return padrinhoRepository.findbyName(nome);
    }

    //UPDATE
    @PatchMapping("/padrinho/atualiza/{id}")
    public void updateNome(@PathVariable Long id, @RequestParam String nome) {
        padrinhoRepository.updateNome(nome, id);
    }

    // DELETE
    @DeleteMapping("/padrinho/{id}")
    public void delete(@PathVariable Long id) {
        padrinhoRepository.delete(id);
    }

}