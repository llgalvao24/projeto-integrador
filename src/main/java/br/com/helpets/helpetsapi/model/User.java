package br.com.helpets.helpetsapi.model;

import br.com.helpets.helpetsapi.model.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Animal> animals = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Donation> donations = new ArrayList<>();

    public User(){
        addProfile(Profile.USER);
    }

    public User(Long id, String firstName, String lastName, String email, String cpf,
                Date birthDate, String phone, String imageUrl, Long frequency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.frequency = frequency;
//        this.loginUser = loginUser;
//        this.address = address;
    }



    public Set<Profile> getProfiles() {
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        profiles.add(profile.getCode());
    }


}
