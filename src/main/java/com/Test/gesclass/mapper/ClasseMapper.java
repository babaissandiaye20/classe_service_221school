package com.Test.gesclass.mapper;

import com.Test.gesclass.dto.ClasseRequest;
import com.Test.gesclass.dto.ClasseResponse;
import com.Test.gesclass.models.Classe;
import org.springframework.stereotype.Component;

@Component
public class ClasseMapper {
    public Classe toClasseEntity(ClasseRequest request) {
        return Classe.builder()
                .code(request.getCode())
                .libelle(request.getLibelle())
                .fraisInscription(request.getFraisInscription())
                .mensualite(request.getMensualite())
                .autreFrais(request.getAutreFrais())
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
        response.setFiliereId(classe.getFiliereId());
        response.setNiveauId(classe.getNiveauId());
        return response;
    }
} 