package br.com.helpets.helpetsapi.perfil;

import br.com.helpets.helpetsapi.administrador.Administrador;
import br.com.helpets.helpetsapi.padrinho.Padrinho;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
//    @Column(unique = true)
    private String cpf;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "sobrenome")
    private String sobrenome;

    @NotNull
    @Column(name = "endereco")
    private String endereco;

    @NotNull
    @Column(name = "bairro")
    private String bairro;

    @NotNull
    @Column(name = "cidade")
    private String cidade;

    @NotNull
    @Column(name = "estado")
    private String estado;

    @NotNull
    @Column(name = "cep")
    private String cep;

    @NotNull
    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @OneToOne(mappedBy = "perfil")
    private Administrador administrador;

    @OneToOne(mappedBy = "perfil")
    private Padrinho padrinho;
}
