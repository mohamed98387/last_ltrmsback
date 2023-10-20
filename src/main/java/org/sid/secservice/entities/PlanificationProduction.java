package org.sid.secservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanificationProduction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matricule;
    private String collaborateur;
    private Long samedi;
    private Long dimanche;
    private Long lundi;
    private Long mardi;
    private Long mercredi;
    private Long jeudi;
    private Long vendredi;
    private String semaine;

}
