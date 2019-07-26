package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@EqualsAndHashCode(exclude = "comments")

@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "post_image")
    private String postImage;

    @NotNull
    @Column(name = "content", nullable = false)
    private String content;

    @NotNull
    @Column(name = "post_data", nullable = false)
    private Instant postData;

    @ManyToOne
    @JsonIgnoreProperties("posts")
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    public Post(String title, String postImage, String content, Instant postData, User user, Comment comments){
        this.title = title;
        this.postImage = postImage;
        this.content = content;
        this.postData = postData;
        this.user = user;
        this.comments = Stream.of(comments).collect(Collectors.toSet());
        this.comments.forEach(x -> x.setPost(this));
    }
}
