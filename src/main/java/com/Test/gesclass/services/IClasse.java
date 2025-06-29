package com.Test.gesclass.services;

import com.Test.gesclass.models.Classe;
import java.util.List;

public interface IClasse {
    List<Classe> findAll();
    Classe save(Classe classe);
    Classe findById(Long id);
    Classe findByCode(String code);
    Classe findByLibelle(String libelle);
    List<Classe> findClassesWithoutThisCode(String code);
    List<Classe> findClassesWithoutThisLibelle(String libelle);
    void delete(Classe classe);
    void softDelete(Long id);
    Classe update(Classe classe);
} 