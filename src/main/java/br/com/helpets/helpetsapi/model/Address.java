package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String streetName;
    private String streetNumber;
    private String reference;
    private String neighbourhood;
    private String zipCode;
    private String city;
    private String state;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;
}
