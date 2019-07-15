package br.com.helpets.helpetsapi.padrinho;

import br.com.helpets.helpetsapi.perfil.Perfil;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data

@Entity
public class Padrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer idPadrinho;

    @OneToOne
    @JoinColumn
    private Perfil perfil;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private String image;
// me disseram que pra imagem é preciso colocar o link dela.

    @NotNull
    private Integer frequencia;

}
