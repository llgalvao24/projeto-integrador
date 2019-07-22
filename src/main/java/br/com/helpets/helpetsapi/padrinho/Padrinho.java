package br.com.helpets.helpetsapi.padrinho;

import br.com.helpets.helpetsapi.animal.Animal;
import br.com.helpets.helpetsapi.comentario.Comentario;
import br.com.helpets.helpetsapi.doacao.Doacao;
import br.com.helpets.helpetsapi.perfil.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "padrinho")
public class Padrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPadrinho;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "senha")
    private String senha;

    @NotNull
    @Column(name = "imagem")
    private String imagem;

    @NotNull
    @Column(name = "frequencia")
    private Date frequencia;

    @OneToOne
    @JsonIgnoreProperties("padrinhos")
    @JoinColumn
    private Perfil perfil;

    @OneToMany(mappedBy = "padrinho")
    private Set<Comentario> comentarios;

    @OneToMany(mappedBy = "padrinho")
    private Set<Doacao> doacaos;

    @OneToMany(mappedBy = "padrinho")
    private Set<Animal> animals;
}
