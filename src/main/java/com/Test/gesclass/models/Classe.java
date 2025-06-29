package com.Test.gesclass.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classe extends BaseModel {
    @Column(length = 25, unique = true)
    private String code;

    @Column(length = 100, unique = true)
    private String libelle;

    private int fraisInscription;
    private int mensualite;
    private int autreFrais;

    // Au lieu d'une relation JPA, on stocke juste l'id de la filière
    private Long filiereId;
    private Long niveauId;
}