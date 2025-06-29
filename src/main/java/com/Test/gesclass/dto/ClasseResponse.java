package com.Test.gesclass.dto;

import lombok.Data;

@Data
public class ClasseResponse {
    private Long id;
    private String code;
    private String libelle;
    private int fraisInscription;
    private int mensualite;
    private int autreFrais;
    private int nombrePlaces;
    private String filiereLibelle;
    private String niveauLibelle;
} 