package com.Test.gesclass.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class ClasseRequest {
    @NotBlank(message = "Le code de la classe est obligatoire.")
    private String code;
    @NotBlank(message = "Le libellé de la classe est obligatoire.")
    private String libelle;
    @NotNull(message = "Le frais d'inscription est obligatoire.")
    private Integer fraisInscription;
    @NotNull(message = "La mensualité est obligatoire.")
    private Integer mensualite;
    @NotNull(message = "L'autre frais est obligatoire.")
    private Integer autreFrais;
    @NotNull(message = "L'identifiant de la filière est obligatoire.")
    private Long filiereId;
    @NotNull(message = "L'identifiant du niveau est obligatoire.")
    private Long niveauId;
} 