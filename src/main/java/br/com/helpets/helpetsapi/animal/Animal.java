package br.com.helpets.helpetsapi.animal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;

    /* TODO - Esperando classe Padrinho
    @ManyToOne
    @JoinColumn
    private Padrinho padrinho;
    */

    @NotNull
    private String tipoAnimal;

    @NotNull
    private String nome;

    @NotNull
    private Integer idade;

    @NotNull
    private String raca;

    @NotNull
    private String porte;

    @NotNull
    private String cor;

    @NotNull
    private Double peso;

    private Boolean vacinado;

}
