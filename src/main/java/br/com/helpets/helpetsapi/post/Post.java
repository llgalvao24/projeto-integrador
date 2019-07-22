package br.com.helpets.helpetsapi.post;

import br.com.helpets.helpetsapi.administrador.Administrador;
import br.com.helpets.helpetsapi.comentario.Comentario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "comentarios")

@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "post_imagem")
    private String postImagem;

    @NotNull
    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @NotNull
    @Column(name = "post_data", nullable = false)
    private Instant postData;

    @ManyToOne
    @JsonIgnoreProperties("posts")
    @JoinColumn
    private Administrador administrador;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;

    public Post(String titulo, String postImagem, String conteudo, Instant postData, Administrador administrador, Comentario comentarios){
        this.titulo = titulo;
        this.postImagem = postImagem;
        this.conteudo = conteudo;
        this.postData = postData;
        this.administrador = administrador;
        this.comentarios = Stream.of(comentarios).collect(Collectors.toSet());
        this.comentarios.forEach(x -> x.setPost(this));
    }
}
