package org.sid.secservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class PlantSection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomPs;
    private String descriptionPS;
    private String emplacementPS;
    private String psManager;
    private String responsableRH;
    private String organisation;
    @OneToMany( mappedBy="ps")
     @JsonIgnore
    private Set<Employe> Employes;

}
