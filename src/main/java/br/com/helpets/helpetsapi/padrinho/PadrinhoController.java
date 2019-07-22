package br.com.helpets.helpetsapi.padrinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PadrinhoController {

    @Autowired
    private PadrinhoRepository padrinhoRepository;

    // CREATE

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/padrinhos")
    public Padrinho save(@RequestBody Padrinho padrinho){
        return padrinhoRepository.save(padrinho);
    }

    // READ

    @GetMapping("/padrinhos")
    public List<Padrinho> findAll(){
        return padrinhoRepository.findAll();
    }

    // UPDATE

    @PatchMapping("/padrinhos/atualiza/{id}")
    public void updateEmail(@PathVariable Long id, @RequestParam String email){
        padrinhoRepository.updateEmail(email, id);
    }

    // DELETE

    @DeleteMapping("/padrinhos/{id}")
    public void delete(@PathVariable Long id){
        padrinhoRepository.deleteById(id);
    }

}
