package com.Test.gesclass.mapper;

import com.Test.gesclass.client.FiliereClient;
import com.Test.gesclass.client.NiveauClient;
import com.Test.gesclass.dto.ClasseRequest;
import com.Test.gesclass.dto.ClasseResponse;
import com.Test.gesclass.models.Classe;
import org.springframework.stereotype.Component;

@Component
public class ClasseMapper {
    private final FiliereClient filiereClient;
    private final NiveauClient niveauClient;

    public ClasseMapper(FiliereClient filiereClient, NiveauClient niveauClient) {
        this.filiereClient = filiereClient;
        this.niveauClient = niveauClient;
    }

    public Classe toClasseEntity(ClasseRequest request) {
        return Classe.builder()
                .code(request.getCode())
                .libelle(request.getLibelle())
                .fraisInscription(request.getFraisInscription())
                .mensualite(request.getMensualite())
                .autreFrais(request.getAutreFrais())
                .nombrePlaces(request.getNombrePlaces())
                .filiereId(request.getFiliereId())
                .niveauId(request.getNiveauId())
                .build();
    }

    public ClasseResponse toClasseResponse(Classe classe) {
        ClasseResponse response = new ClasseResponse();
        response.setId(classe.getId());
        response.setCode(classe.getCode());
        response.setLibelle(classe.getLibelle());
        response.setFraisInscription(classe.getFraisInscription());
        response.setMensualite(classe.getMensualite());
        response.setAutreFrais(classe.getAutreFrais());
        response.setNombrePlaces(classe.getNombrePlaces());
        
        // Récupérer les libellés des filières et niveaux
        try {
            String filiereLibelle = filiereClient.getLibelleById(classe.getFiliereId());
            response.setFiliereLibelle(filiereLibelle);
        } catch (Exception e) {
            response.setFiliereLibelle("Filière ID: " + classe.getFiliereId() + " (Service indisponible)");
        }
        
        try {
            String niveauLibelle = niveauClient.getLibelleById(classe.getNiveauId());
            response.setNiveauLibelle(niveauLibelle);
        } catch (Exception e) {
            response.setNiveauLibelle("Niveau ID: " + classe.getNiveauId() + " (Service indisponible)");
        }
        
        return response;
    }
} 