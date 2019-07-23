package br.com.helpets.helpetsapi.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    // CREATE

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/animais")
    public Animal save(@Valid @RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    // READ

    @GetMapping("/animais")
    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    // UPDATE

    @PatchMapping("/animais/atualiza/{id}")
    public void updateNome(@PathVariable Long id, @RequestParam String animalNome){
        animalRepository.updateNome(animalNome,id);
    }

    // DELETE

    @DeleteMapping("/animais/{id}")
    public void delete(@PathVariable Long id){
        animalRepository.deleteById(id);
    }

}
