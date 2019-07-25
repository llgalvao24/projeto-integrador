package br.com.helpets.helpetsapi.model;

import br.com.helpets.helpetsapi.model.Comentario;
import br.com.helpets.helpetsapi.model.Post;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
//    @Column(unique = true)
    private String cpf;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "bairro")
    private String bairro;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "")
    private String estado;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @NotNull
    @Column(name = "imagem")
    private String imagem;

    @NotNull
    @Column(name = "frequencia")
    private Date frequencia;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

    // Lembrar de colocar um IF no front para o acesso do admin
    @OneToMany
    private Set<Post> posts;

    @OneToMany
    private Set<Comentario> comentarios;
}
