package org.sid.secservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agence implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;
    private String nomEntreprise;
    private Integer numeroTelephone;
    private String matriculeFiscal;
    private String horaireTravail;
    private String email;
    private String siteInternet;
    @OneToMany( mappedBy="agence")
    @JsonIgnore
    private Set<Vehicule> Vehicules;
    @OneToMany( mappedBy="agence")
    @JsonIgnore
    private Set<Chauffeur> Chauffeures;
    @OneToMany( mappedBy="agence")
    @JsonIgnore
    private Set<Circuit> Circuits;

}
