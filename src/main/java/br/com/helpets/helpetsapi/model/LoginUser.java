package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String username;
    private String password;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    public LoginUser(String username, String password, User user) {
        this.username = username;
        this.password = password;
        this.user = user;
    }
}
