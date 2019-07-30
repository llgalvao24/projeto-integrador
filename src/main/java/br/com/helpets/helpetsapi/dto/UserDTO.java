package br.com.helpets.helpetsapi.dto;

import br.com.helpets.helpetsapi.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter @Setter
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String firstName;
    private String lastName;

    @Email(message = "Invalid email")
    private String email;

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
        birthDate = obj.getBirthDate();
        phone = obj.getPhone();
        imageUrl = obj.getImageUrl();
        frequency = obj.getFrequency();
    }

    public UserDTO(){
    }

}
