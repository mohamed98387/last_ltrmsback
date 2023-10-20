package org.sid.secservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalPlanificationTransport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Agence;
    private String Circuit;
    private String jourSemaine;
    private Integer debutPoste;
    private Integer FinPoste;
    private Integer NombreEmploye=0;
    private Integer NombresBus=0;
}
