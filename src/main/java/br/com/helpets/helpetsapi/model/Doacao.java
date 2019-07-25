package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "doacao")
public class Doacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "racao")
    private Long racao;

    @NotNull
    @Column(name = "banhoTosa")
    private Long banhoTosa;

    @NotNull
    @Column(name = "medicamentos")
    private Long medicamento;

    @NotNull
    @Column(name = "acessorio")
    private Long acessorio;

    @ManyToOne
    @JsonIgnoreProperties("doacaos")
    @JoinColumn
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("doacaos")
    @JoinColumn
    private Animal animal;
}