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
public class Segment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomSegment;
    private String centerCoutSegment;
    private String nomSapRef;
    private String ps;
    private String rhSegment;
    private String chefSegment;
    @OneToMany( mappedBy="segment")
    @JsonIgnore
    private Set<Employe> Employes;


}
