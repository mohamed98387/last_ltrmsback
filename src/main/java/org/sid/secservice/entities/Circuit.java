package org.sid.secservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circuit  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String refChemin;
    private String refSap;
    private Integer nbKilometre;
    private String contributionEmploye;
    private Integer coutKm;
    private String pointArrive;
    @ManyToOne
    private Agence agence;
}
