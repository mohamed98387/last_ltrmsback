package org.sid.secservice.entities;

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
public class PlanificationTransport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Agence;
    private String Circuit;
    private String jourSemaine;
    private Integer DebutPoste;
    private Integer FinPoste;
    private Integer NombreEmploye;
    private Integer NombresBus;

}
