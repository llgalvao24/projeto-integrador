package br.com.helpets.helpetsapi.padrinho;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
public class Padrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPadrinho;

    @NotNull
    private String email;

    @NotNull
    private String senha;

    private String imagem;
    private Date frequencia;

}
