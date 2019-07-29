package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "animal")
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull
    @Column(name = "animal_nome", nullable = false)
    private String animalName;

    @NotNull
    @Column(name = "age", nullable = false)
    private Integer age;

    @NotNull
    @Column(name = "breed", nullable = false)
    private String breed;

    @NotNull
    @Column(name = "size", nullable = false)
    private String size;

    @NotNull
    @Column(name = "main_color", nullable = false)
    private String mainColor;

    @Column(name = "weight", nullable = false)
    private Double weight;

    @Column(name = "vaccine", nullable = false)
    private Boolean vaccine;

    @ManyToOne
    @JsonIgnoreProperties("animals")
    @JoinColumn
    private User user;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "animal")
    private Set<Donation> donations = new HashSet<>();
}
