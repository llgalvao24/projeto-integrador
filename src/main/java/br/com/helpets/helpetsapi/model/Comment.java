package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "comment")
@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @NotNull
    @Column(name = "comm_data", nullable = false)
    private Instant commData;

    @ManyToOne
    @JsonIgnoreProperties("comments")
    @JoinColumn
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("comments")
    @JoinColumn
    private Post post;
}
