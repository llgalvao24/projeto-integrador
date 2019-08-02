package org.generation.brazil.backend.animal;

import org.generation.brazil.backend.exception.myexc.ObjectNotFoundException;
import org.generation.brazil.backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional
    public Animal insert(Animal obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Animal update(Animal obj) {
        Animal newObj = find(obj.getId()); //verify if obj exists
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Long id){
        find(id);
        repo.deleteById(id);
    }

    public List<Animal> findAll() {
        return repo.findAll();
    }

    public List<Animal>findAllByUser(User user){
        return repo.findAnimalsByUser(user);
    }

    public Animal fromDTO(AnimalDTO objDto) {
        return new Animal(null, objDto.getType(), objDto.getAnimalName(), objDto.getAge(), objDto.getBreed(), objDto.getSize(),
                objDto.getMainColor(), objDto.getWeight(), objDto.getVaccine(), null);
    }

    //sets what user/adm is allowed to update or not
    private void updateData(Animal newObj, Animal obj) {
        newObj.setType(obj.getType());
        newObj.setAnimalName(obj.getAnimalName());
        newObj.setAge(obj.getAge());
        newObj.setBreed(obj.getBreed());
        newObj.setSize(obj.getSize());
        newObj.setMainColor(obj.getMainColor());
        newObj.setWeight(obj.getWeight());
        newObj.setVaccine(obj.getVaccine());
    }

}
