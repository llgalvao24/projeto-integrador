package br.com.helpets.helpetsapi.controller;

import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.Animal;
import br.com.helpets.helpetsapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable(value = "id") Long animalId)
            throws ResourceNotFoundException {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ResourceNotFoundException("animal not found for this id: " + animalId));
        return ResponseEntity.ok().body(animal);
    }

    @PostMapping("/animals")
    public Animal createAnimal(@Valid @RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable(value = "id") Long animalId,
                                           @Valid @RequestBody Animal animalDetails) throws ResourceNotFoundException {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ResourceNotFoundException("animal not found for this id: " + animalId));

        animal.setAge(animalDetails.getAge());
        animal.setAnimalName(animalDetails.getAnimalName());
        animal.setBreed(animalDetails.getBreed());
        animal.setMainColor(animalDetails.getMainColor());
        animal.setSize(animalDetails.getSize());
        animal.setType(animalDetails.getType());
        animal.setVaccine(animalDetails.getVaccine());
        animal.setWeight(animalDetails.getWeight());

        final Animal updatedAnimal = animalRepository.save(animal);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/animals/{id}")
    public Map<String, Boolean> deleteAnimal(@PathVariable(value = "id") Long animalId)
            throws ResourceNotFoundException {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ResourceNotFoundException("animal not found for this id: " + animalId));

        animalRepository.delete(animal);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
