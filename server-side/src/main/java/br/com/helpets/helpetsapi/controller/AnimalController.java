package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.repository.AnimalRepository;
import br.com.helpets.helpetsapi.model.Animal;
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
    @PostMapping("/animals")
    public Animal save(@Valid @RequestBody Animal animal){
        return animalRepository.save(animal);
    }

    // READ

    @GetMapping("/animals")
    public List<Animal> findAll(){
        return animalRepository.findAll();
    }

    // UPDATE

    @PatchMapping("/animals/update/{id}")
    public void updateName(@PathVariable Long id, @RequestParam String animalName){
        animalRepository.updateName(animalName,id);
    }

    // DELETE

    @DeleteMapping("/animals/{id}")
    public void delete(@PathVariable Long id){
        animalRepository.deleteById(id);
    }

}
