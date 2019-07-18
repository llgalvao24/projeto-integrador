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
    private Long idPost;

//    @NotNull
//    @NotBlank
//    private Administrador administrador;
    
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
    private Date dataHoraPost;
}
