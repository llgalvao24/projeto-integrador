package org.generation.brazil.backend.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Date;

@Getter @Setter
public class UserNewDTO implements Serializable {

    //validation such as @NotNull, @NotEmpty, @Size are done in DTO classes, @CPF

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    private String name;

    @Email(message = "Invalid email")
    private String email;
    private String cpf;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;

    private String phone;
    private String imageUrl;
    private Long frequency;

    private String streetName;
    private String streetNumber;
    private String reference;
    private String neighbourhood;
    private String zipCode;
    private String city;
    private String state;

    public UserNewDTO(){
    }


}
