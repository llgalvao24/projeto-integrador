package br.com.helpets.helpetsapi.dto;

import br.com.helpets.helpetsapi.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter @Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cpf;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;

    private String phone;
    private String imageUrl;
    private Long frequency;

    public UserDTO(User obj){
        id = obj.getId();
        firstName = obj.getFirstName();
        lastName = obj.getLastName();
        email = obj.getEmail();
        cpf = obj.getCpf();
        birthDate = obj.getBirthDate();
        phone = obj.getPhone();
        imageUrl = obj.getImageUrl();
        frequency = obj.getFrequency();
    }

    public UserDTO(){
    }

}
