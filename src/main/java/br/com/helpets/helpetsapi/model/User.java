package br.com.helpets.helpetsapi.model;

import br.com.helpets.helpetsapi.model.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Getter @Setter @EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String cpf;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;

    private String phone;
    private String imageUrl;
    private Long frequency;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private LoginUser loginUser;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Address address;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name="PROFILES")
    private Set<Integer> profiles = new HashSet<>();

    // Lembrar de colocar um IF no front para o acesso do admin
    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    @OneToMany
    private Set<Comment> comments = new HashSet<>();

    @OneToMany
    private Set<Animal> animals = new HashSet<>();

    @OneToMany
    private Set<Donation> donations = new HashSet<>();

    public User(){
        addProfile(Profile.USER);
    }

    public User(String firstName, String lastName, String email, String cpf, Date birthDate,
                String phone, String imageUrl, Long frequency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.frequency = frequency;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getCode());
    }


    public void addPost(Post post){
        posts.add(post);
    }

    public void deletePost(Post post){
        posts.remove(post);
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void deleteComment(Optional<Comment> comment){
        comments.remove(comment);
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void deleteAnimal(Optional<Animal> animal){
        animals.remove(animal);
    }

    public void addDonation(Donation donation){
        donations.add(donation);
    }

    public void deleteDonation(Optional<Donation> donation){
        donations.remove(donations);
    }
}
