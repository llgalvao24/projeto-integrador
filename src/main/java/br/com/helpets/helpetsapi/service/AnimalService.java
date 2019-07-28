package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.exception.ResourceNotFoundException;
import br.com.helpets.helpetsapi.model.Animal;
import br.com.helpets.helpetsapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal findAnimal(Long id) {
        Optional<Animal> obj = animalRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(
                "Animal not found for this id: " + id));
    }
}
