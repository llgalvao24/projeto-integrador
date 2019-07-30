package br.com.helpets.helpetsapi.dto;

import br.com.helpets.helpetsapi.model.Animal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class AnimalDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String type;
    private String animalName;
    private Integer age;
    private String breed;
    private String size;
    private String mainColor;
    private Double weight;
    private Boolean vaccine;

    public AnimalDTO(Animal obj){
        id = obj.getId();
        type = obj.getType();
        animalName = obj.getAnimalName();
        age = obj.getAge();
        breed = obj.getBreed();
        size = obj.getSize();
        mainColor = obj.getMainColor();
        weight = obj.getWeight();
        vaccine = obj.getVaccine();
    }

    public AnimalDTO(){
    }
}
