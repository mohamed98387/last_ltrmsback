package org.sid.secservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long matricule;
    private String nom;
    private String prenom;
    private String contreMetre;
    private String nomGroupe;
    private Long telephone;
    private Long centreCout;
    @ManyToOne
    PlantSection ps;
    @ManyToOne
    Segment segment;
    @ManyToOne
    Station station;

}
