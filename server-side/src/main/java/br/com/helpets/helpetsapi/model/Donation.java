package br.com.helpets.helpetsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "donation")
public class Donation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "food")
    private Long food;

    @NotNull
    @Column(name = "groom")
    private Long groom;

    @NotNull
    @Column(name = "medication")
    private Long medication;

    @NotNull
    @Column(name = "accessory")
    private Long accessory;

    @ManyToOne
    @JsonIgnoreProperties("donations")
    @JoinColumn
    private User user;

    @ManyToOne
    @JsonIgnoreProperties("donations")
    @JoinColumn
    private Animal animal;
}
