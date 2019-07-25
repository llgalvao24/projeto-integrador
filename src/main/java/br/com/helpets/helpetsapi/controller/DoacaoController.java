package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.model.Doacao;
import br.com.helpets.helpetsapi.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DoacaoController {

    @Autowired//Força a injeção de dependencia
    private DoacaoRepository doacaoRepository;


    // Criar
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/doacao")
    public Doacao save(@RequestBody Doacao doacao){
        return doacaoRepository.save(doacao);// repository é o meud DB.
    }

    // Read
    @GetMapping("/doacao")
    public List<Doacao> findAll(){
        return doacaoRepository.findAll(); //
    }


    //Update com Lambida
    @PutMapping(value="/doacao/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Doacao doacao) {
        return doacaoRepository.findById(id)
                .map(record -> {
                    record.setRacao(doacao.getRacao());
                    record.setBanhoTosa(doacao.getBanhoTosa());
                    record.setMedicamento(doacao.getMedicamento());
                    Doacao updated = doacaoRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/doacao/{id}")
    public void delete(@PathVariable Long id){
        doacaoRepository.deleteById(id);
    }


}


