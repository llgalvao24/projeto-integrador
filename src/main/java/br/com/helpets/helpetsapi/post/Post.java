package br.com.helpets.helpetsapi.post;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id_post;

    @NotNull
    @NotBlank
    private Integer fk_administrador;
    
    @NotNull
    @NotBlank
    private String titulo;
    
    @NotNull
    @NotBlank
    private String texto;
    
    
    @NotNull
    @NotBlank
    private String imagem;
    
        

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_post;
}
