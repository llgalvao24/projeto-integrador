package br.com.helpets.helpetsapi.comentario;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class Comentario {

    @Id
    @NotNull
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

    private LocalDateTime dateTime;
}
