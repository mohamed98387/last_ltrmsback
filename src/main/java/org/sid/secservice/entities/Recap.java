package org.sid.secservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recap implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matricule;
    private String fullName;
    private String segment;
    private String plantSection;
    private String circuit;
    private String station;
    private String Prestataire;
    private Long samedi;
    private Long dimanche;
    private Long lundi;
    private Long mardi;
    private Long mercredi;
    private Long jeudi;
    private Long vendredi;
    private String importePar;
    private LocalDateTime dateImport;

}
