package br.com.helpets.helpetsapi.animal;

import br.com.helpets.helpetsapi.doacao.Doacao;
import br.com.helpets.helpetsapi.padrinho.Padrinho;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animal")
@Data
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "animal_tipo", nullable = false)
    private String animaTipo;

    @NotNull
    @Column(name = "animal_nome", nullable = false)
    private String animalNome;

    @NotNull
    @Column(name = "idade", nullable = false)
    private Integer idade;

    @NotNull
    @Column(name = "raca", nullable = false)
    private String raca;

    @NotNull
    @Column(name = "porte", nullable = false)
    private String porte;

    @NotNull
    @Column(name = "cor_principal", nullable = false)
    private String corPrincipal;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "vacina", nullable = false)
    private Boolean vacina;

    @ManyToOne
    @JsonIgnoreProperties("animals")
    private Padrinho padrinho;

    @OneToMany(mappedBy = "animal")
    private Set<Doacao> doacoes = new HashSet<>();

    /* TODO - Testar anotações
    @ManyToOne
    @JoinColumn
    private Padrinho padrinho;
    */

}
