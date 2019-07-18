package br.com.helpets.helpetsapi.post;

import br.com.helpets.helpetsapi.comentario.Comentario;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "comentarios")

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

//    @NotNull
//    @NotBlank
//    private Administrador administrador;
    
    @NotNull
    @NotBlank
    private String titulo;
    
    @NotNull
    @NotBlank
    private String texto;
    
    
    @NotNull
    @NotBlank
    private String imagem;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraPost;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comentario> comentarios;

    public Post(String titulo, String texto, String imagem, Comentario comentarios){
        this.titulo = titulo;
        this.texto = texto;
        this.imagem = imagem;
        this.comentarios = Stream.of(comentarios).collect(Collectors.toSet());
        this.comentarios.forEach(x -> x.setPost(this));
    }
}
