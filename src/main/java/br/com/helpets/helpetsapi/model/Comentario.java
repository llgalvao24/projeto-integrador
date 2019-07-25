package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "comentario")
@Data
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @NotNull
    @Column(name = "com_data", nullable = false)
    private Instant comData;

    @ManyToOne
    @JsonIgnoreProperties("comentarios")
    @JoinColumn
    private User user;


    @ManyToOne
    @JsonIgnoreProperties("comentarios")
    @JoinColumn
    private Post post;

    /* TODO - Testar anotações de fk
    @ManyToOne
    @JoinColumn
    private Padrinho padrinho;
    */
}
