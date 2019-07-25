package br.com.helpets.helpetsapi.model;

import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class UserDto {

    private int id;
    private String username;
    private String password;
    private String email;
    private String cpf;
    private String firstName;
    private String lastName;
    private String address;
    private String neighborhood;
    private String city;
    private String state;
    private String cep;
    private Date birthDate;
    private String phone;
    private String image;
    private Date frequency;
    private Set<Post> posts;
    private Set<Comentario> comentarios;
}
