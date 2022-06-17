package com.compta.compta.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.compta.compta.model.Ecriture;
import com.compta.compta.model.LigneEcriture;


public interface LigneEcritureRepository extends JpaRepository<LigneEcriture, Long>{

	
    Iterable<LigneEcriture> findAllByNumero(int numero);
    Optional<LigneEcriture> findByEcriture(Long id);
	@Modifying
    @Transactional
    @Query("delete from LigneEcriture le where numero = ?1")
    void deleteByNumero(int numero);
	
	
	/*@Query("select * from LigneEcriture le,Ecriture e where le.ecriture_id=:e.id")
	void findEcrt(@Param("ecriture_id") String ecriture_id);*/
	
	
/*
	
	@Query("select * from LigneEcriture le where le.numero=:Ecriture.num_ecrt")
	List<LigneEcriture> getLignesByNumero(@Param("num_ecrt") Long num_ecrt);
	*/
	
	
}


