package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String streetName;
    private String streetNumber;
    private String reference;
    private String neighbourhood;
    private String zipCode;
    private String city;
    private String state;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    private User user;

    public Address(String streetName, String streetNumber, String reference, String neighbourhood, String zipCode, String city, String state, User user) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.reference = reference;
        this.neighbourhood = neighbourhood;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.user = user;
    }
}
