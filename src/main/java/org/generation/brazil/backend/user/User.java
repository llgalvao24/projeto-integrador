package org.generation.brazil.backend.user;

import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.generation.brazil.backend.address.Address;
import org.generation.brazil.backend.animal.Animal;
import org.generation.brazil.backend.comment.Comment;
import org.generation.brazil.backend.donation.Donation;
import org.generation.brazil.backend.post.Post;
import org.generation.brazil.backend.role.Role;


@Entity
@Getter @Setter
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "username"
    }),
    @UniqueConstraint(columnNames = {
        "email"
    })
})
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String username;
  @NotBlank
  @Size(max = 100)
  private String password;

  private String name;

  @Email
  @NotBlank
  @Size(max = 40)
  private String email;

  private String cpf;

  @JsonFormat(pattern="dd/MM/yyyy")
  private Date birthDate;

  private String phone;
  private String imageUrl;
  private Long frequency;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private Address address;

  @OneToMany(mappedBy = "user")
  private Set<Post> posts = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Comment> comments = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private Set<Animal> animals = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "user")
  private List<Donation> donations = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public User(){
  }

  public User(Long id, String username, String password, String name, String email, String cpf,
              Date birthDate, String phone, String imageUrl, Long frequency) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
    this.cpf = cpf;
    this.birthDate = birthDate;
    this.phone = phone;
    this.imageUrl = imageUrl;
    this.frequency = frequency;
//        this.address = address;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("User{");
    sb.append("id=").append(id);
    sb.append(", username='").append(username).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", Name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
