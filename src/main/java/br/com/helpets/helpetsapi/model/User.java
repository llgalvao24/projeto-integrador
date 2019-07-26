package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "cpf")
    private String cpf;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "number")
    private String number;

    @NotNull
    @Column(name = "neighborhood")
    private String neighborhood;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "state")
    private String state;

    @NotNull
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull
    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @Column(name = "image_url")
    private String imageUrl;

    @NotNull
    @Column(name = "frequency")
    private Date frequency;

    // Lembrar de colocar um IF no front para o acesso do admin
    @OneToMany
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<Post> posts = new HashSet<>();

    @OneToMany
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<Comment> comments = new HashSet<>();

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
}
