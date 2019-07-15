package br.com.helpets.helpetsapi.perfil;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data

@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;

    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    private String sobrenome;

    @NotNull
    private String endereco;

    @NotNull
    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String cep;

    @NotNull
    private Date dataNascimento;

}
