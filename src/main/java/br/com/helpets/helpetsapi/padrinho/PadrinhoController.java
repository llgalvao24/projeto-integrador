package br.com.helpets.helpetsapi.padrinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PadrinhoController {

    @Autowired
    private PadrinhoRepository padrinhoRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/padrinho")
    public Padrinho save(@RequestBody Padrinho padrinho) {
        return padrinhoRepository.save(padrinho);
    }
}