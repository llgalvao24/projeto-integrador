package br.com.helpets.helpetsapi.administrador;

import br.com.helpets.helpetsapi.comentario.Comentario;
import br.com.helpets.helpetsapi.perfil.Perfil;
import br.com.helpets.helpetsapi.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "email", nullable = false)
    private String email ;

    @NotNull
    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToOne
    @JsonIgnoreProperties("perfils")
    @JoinColumn
    private Perfil perfil;

    @OneToMany(mappedBy = "administrador")
    private Set<Post> posts;

    @OneToMany(mappedBy = "administrador")
    private Set<Comentario> comentarios;
}
