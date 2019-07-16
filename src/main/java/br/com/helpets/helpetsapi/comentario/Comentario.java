package br.com.helpets.helpetsapi.comentario;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    /* TODO - Esperando classe Padrinho
    @ManyToOne
    @JoinColumn
    private Padrinho padrinho;
    */

    /* TODO - Esperando classe Post
    @ManyToOne
    @JoinColumn
    private Post post;
    */

    @NotNull
    @NotBlank
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
}