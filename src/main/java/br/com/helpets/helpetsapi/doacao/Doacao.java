package br.com.helpets.helpetsapi.doacao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Doacao {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoacao;

    @NotNull
    int racao ;

    @NotNull
    int banhoTosa;

    @NotNull
    int medicamentosVacina;


    @NotNull
    int acessorios;



}
