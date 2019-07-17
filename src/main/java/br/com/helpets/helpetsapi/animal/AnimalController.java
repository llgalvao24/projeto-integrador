package br.com.helpets.helpetsapi.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    // CREATE

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/animais")
    public Animal save(@RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    // READ

    @GetMapping("/animais")
    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    // UPDATE

    @PatchMapping("/animais/atualiza/{idAnimal}")
    public void updateNome(@PathVariable Long idAnimal, @RequestParam String nome){
        animalRepository.updateNome(nome,idAnimal);
    }

    // DELETE

    @DeleteMapping("/animais/{idAnimal}")
    public void delete(@PathVariable Long idAnimal){
        animalRepository.deleteById(idAnimal);
    }

}
