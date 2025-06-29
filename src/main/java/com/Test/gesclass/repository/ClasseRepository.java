package com.Test.gesclass.repository;

import com.Test.gesclass.models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    Classe findByCode(String code);
    Classe findByLibelle(String libelle);

    @Query("SELECT c FROM Classe c WHERE c.code != :code")
    List<Classe> findClassesWithoutThisCode(String code);

    @Query("SELECT c FROM Classe c WHERE c.libelle != :libelle")
    List<Classe> findClassesWithoutThisLibelle(String libelle);

    @Query("SELECT c FROM Classe c WHERE c.deleted = false")
    List<Classe> findAllNotDeleted();
} 