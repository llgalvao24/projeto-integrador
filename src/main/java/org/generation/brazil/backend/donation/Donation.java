package org.generation.brazil.backend.donation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.brazil.backend.animal.Animal;
import org.generation.brazil.backend.user.User;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Setter @Getter
@EqualsAndHashCode
@NoArgsConstructor
public class Donation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long food;
    private Long groom;
    private Long medication;
    private Long accessory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Donation(Long id, Long food, Long groom, Long medication, Long accessory, User user, Animal animal) {
        this.id = id;
        this.food = food;
        this.groom = groom;
        this.medication = medication;
        this.accessory = accessory;
        this.user = user;
        this.animal = animal;
    }
}
