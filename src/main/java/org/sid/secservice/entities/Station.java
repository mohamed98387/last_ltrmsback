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
public class Station implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String refRegion;
    private String refSap;
    private Integer longitude;
    private Integer latitude;
    private Integer rayon;
    @OneToMany( mappedBy="station")
    @JsonIgnore
    private Set<Employe> Employes;

}
