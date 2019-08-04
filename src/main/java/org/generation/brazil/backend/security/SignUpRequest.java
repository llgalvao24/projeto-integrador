package org.generation.brazil.backend.security;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SignUpRequest {

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

}
