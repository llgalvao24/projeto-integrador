package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String animalName;
    private Integer age;
    private String breed;
    private String size;
    private String mainColor;
    private Double weight;
    private Boolean vaccine;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "animal")
    private Set<Donation> donations = new HashSet<>();

    public Animal(String type, String animalName, Integer age, String breed,
                  String size, String mainColor, Double weight, Boolean vaccine, User user) {
        this.type = type;
        this.animalName = animalName;
        this.age = age;
        this.breed = breed;
        this.size = size;
        this.mainColor = mainColor;
        this.weight = weight;
        this.vaccine = vaccine;
        this.user = user;
    }
}
