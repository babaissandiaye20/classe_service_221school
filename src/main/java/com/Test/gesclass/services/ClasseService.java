package com.Test.gesclass.services;

import com.Test.gesclass.models.Classe;
import com.Test.gesclass.repository.ClasseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClasseService implements IClasse {
    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }

    @Override
    public Classe save(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public Classe findById(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public Classe findByCode(String code) {
        return classeRepository.findByCode(code);
    }

    @Override
    public Classe findByLibelle(String libelle) {
        return classeRepository.findByLibelle(libelle);
    }

    @Override
    public List<Classe> findClassesWithoutThisCode(String code) {
        return classeRepository.findClassesWithoutThisCode(code);
    }

    @Override
    public List<Classe> findClassesWithoutThisLibelle(String libelle) {
        return classeRepository.findClassesWithoutThisLibelle(libelle);
    }

    @Override
    public void delete(Classe classe) {
        classeRepository.delete(classe);
    }

    @Override
    public void softDelete(Long id) {
        Classe classe = classeRepository.findById(id).orElse(null);
        if (classe != null) {
            classe.setDeleted(true);
            classeRepository.save(classe);
        }
    }

    @Override
    public Classe update(Classe classe) {
        return classeRepository.save(classe);
    }
} 