package com.Test.gesclass.helper;

import com.Test.gesclass.client.FiliereClient;
import com.Test.gesclass.client.NiveauClient;
import com.Test.gesclass.dto.ClasseRequest;
import com.Test.gesclass.dto.ClasseResponse;
import com.Test.gesclass.exception.ApiException;
import com.Test.gesclass.exception.NotFoundException;
import com.Test.gesclass.mapper.ClasseMapper;
import com.Test.gesclass.models.Classe;
import com.Test.gesclass.services.IClasse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ClasseHelper {
    private final IClasse iClasse;
    private final ClasseMapper classeMapper;
    private final FiliereClient filiereClient;
    private final NiveauClient niveauClient;

    public ClasseHelper(IClasse iClasse, ClasseMapper classeMapper, FiliereClient filiereClient, NiveauClient niveauClient) {
        this.iClasse = iClasse;
        this.classeMapper = classeMapper;
        this.filiereClient = filiereClient;
        this.niveauClient = niveauClient;
    }

    public ClasseResponse save(ClasseRequest classeRequest) {
        if (iClasse.findByCode(classeRequest.getCode()) != null) {
            throw new ApiException("Une classe avec le code [" + classeRequest.getCode() + "] existe déjà!", 400);
        }
        if (iClasse.findByLibelle(classeRequest.getLibelle()) != null) {
            throw new ApiException("Une classe avec le libellé [" + classeRequest.getLibelle() + "] existe déjà!", 400);
        }
        // Vérification existence filière
        if (!filiereClient.existsById(classeRequest.getFiliereId())) {
            throw new NotFoundException("Filière avec id [" + classeRequest.getFiliereId() + "] inexistante!");
        }
        // Vérification existence niveau
        if (!niveauClient.existsById(classeRequest.getNiveauId())) {
            throw new NotFoundException("Niveau avec id [" + classeRequest.getNiveauId() + "] inexistant!");
        }
        Classe classe = iClasse.save(classeMapper.toClasseEntity(classeRequest));
        return classeMapper.toClasseResponse(classe);
    }

    public List<ClasseResponse> findAll() {
        return iClasse.findAll().stream().map(classeMapper::toClasseResponse).toList();
    }

    public ClasseResponse findById(Long id) {
        Classe classe = iClasse.findById(id);
        if (classe == null) {
            throw new NotFoundException("Classe avec id " + id + " introuvable");
        }
        return classeMapper.toClasseResponse(classe);
    }

    // Méthodes update et delete à adapter selon besoin
} 