package br.com.helpets.helpetsapi.service;

import br.com.helpets.helpetsapi.service.exception.ObjectNotFoundException;
import br.com.helpets.helpetsapi.model.Animal;
import br.com.helpets.helpetsapi.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository repo;

    public Animal find(Long id){
        Optional<Animal> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found for this id: " + id + ", Type: " + Animal.class.getName() ));
    }

    public Animal insert(Animal obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }


}
