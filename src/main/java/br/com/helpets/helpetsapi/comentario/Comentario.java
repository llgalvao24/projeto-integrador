package br.com.helpets.helpetsapi.comentario;

import br.com.helpets.helpetsapi.post.Post;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    /* TODO - Esperando classe Padrinho
    @ManyToOne
    @JoinColumn
    private Padrinho padrinho;
    */

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

    @NotNull
    @NotBlank
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}
