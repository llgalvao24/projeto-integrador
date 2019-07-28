package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private Date commData;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    @Getter(AccessLevel.NONE)
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "post_id")
    @Getter(AccessLevel.NONE)
    private Post post;

    public Comment(String content, Date commData, User user, Post post) {
        this.content = content;
        this.commData = commData;
        this.user = user;
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id.equals(comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
