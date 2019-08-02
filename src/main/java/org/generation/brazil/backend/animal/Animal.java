package org.generation.brazil.backend.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.brazil.backend.donation.Donation;
import org.generation.brazil.backend.user.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Donation> donations = new ArrayList<>();

    public Animal(Long id, String type, String animalName, Integer age, String breed,
                  String size, String mainColor, Double weight, Boolean vaccine, User user) {
        this.id = id;
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
