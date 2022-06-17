package com.compta.compta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.compta.compta.model.Exercice_comptable;

@Repository
public interface ExerciceRepository extends JpaRepository<Exercice_comptable, Long>{

}
